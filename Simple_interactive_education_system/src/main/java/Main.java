import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        // Ask for database connection info
        System.out.print("Enter database URL: ");
        String url = scanner.nextLine();

        System.out.print("Enter database user: ");
        String user = scanner.nextLine();

        System.out.print("Enter database password: ");
        String password = scanner.nextLine();

        System.out.print("Enter database driver class name: ");
        String driver = scanner.nextLine();

        Configuration config = new Configuration(url, user, password, driver);
        config.connect();

        //Create student table with course columns
        Map<String, String> studentColumns = new HashMap<>();
        studentColumns.put("id", "INT PRIMARY KEY");
        studentColumns.put("name", "VARCHAR(100)");
        studentColumns.put("age", "INT");
        studentColumns.put("email", "VARCHAR(100)");
        studentColumns.put("course_classname", "VARCHAR(100)");
        studentColumns.put("course_credits", "INT");
        studentColumns.put("course_professor", "VARCHAR(100)");

        config.createTable("student", studentColumns);

        //Interactive menu loop
        boolean running = true;
        while (running) {
            System.out.println("\nOptions: add, update, delete, get, exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine().trim().toLowerCase();

            switch (option) {
                case "add":
                    Configuration.Student newStudent = readStudent(scanner);
                    insertStudentWithCourse(config, newStudent);
                    break;

                case "update":
                    System.out.print("Enter the ID of the student to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    Configuration.Student updatedStudent = readStudent(scanner);
                    updatedStudent.setId(updateId); // keep the same ID
                    config.updateStudentById(updateId, updatedStudent);
                    break;

                case "delete":
                    System.out.print("Enter the ID of the student to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    config.deleteStudentById(deleteId);
                    break;

                case "get":
                    System.out.print("Enter the ID of the student to get: ");
                    int getId = Integer.parseInt(scanner.nextLine());
                    Configuration.Student student = config.getStudentById(getId);
                    if (student != null) {
                        System.out.println("Student found: " + student);
                    } else {
                        System.out.println("Student with ID " + getId + " not found.");
                    }
                    break;

                case "exit":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    // Helper to read a student + course info interactively from console
    private static Configuration.Student readStudent(Scanner scanner) {
        System.out.print("Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Student Age (int): ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Student Email: ");
        String email = scanner.nextLine();

        System.out.print("Course Classname: ");
        String classname = scanner.nextLine();

        System.out.print("Course Credits (int): ");
        int credits = Integer.parseInt(scanner.nextLine());

        System.out.print("Course Professor: ");
        String professor = scanner.nextLine();

        Configuration.Course course = new Configuration.Course(classname, credits, professor);

        // ID will be set separately (like in add or update)
        return new Configuration.Student(null, name, age, email, course);
    }

    // Inserts a student along with course info in the database
    private static void insertStudentWithCourse(Configuration config, Configuration.Student student) throws SQLException {
        System.out.print("Student ID (int): ");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());
        student.setId(id);

        // Use prepared statement with all fields including course
        String sql = "INSERT INTO student (id, name, age, email, course_classname, course_credits, course_professor) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = config.connection.prepareStatement(sql)) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getEmail());

            Configuration.Course c = student.getCourse();
            pstmt.setString(5, c.getClassname());
            pstmt.setInt(6, c.getCredits());
            pstmt.setString(7, c.getProfessor());

            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");
        }
    }
}