import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Slf4j
public class Configuration {

    String url;
    String user;
    String password;
    String driver;
    Connection connection;

    public Configuration(String url, String user, String password, String driver) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }

    //method for dynamically connecting database
    public void connect() throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        log.info("Connected to database");
    }

    //method for creating table
    public void createTable(String name, Map<String, String> columntypes) throws SQLException {
        StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS" + name + " (");
        int i = 0;
        for (Map.Entry<String, String> entry : columntypes.entrySet()) {
            sql.append(entry.getKey()).append(" ").append(entry.getValue());
            if (i < columntypes.size() - 1) {
                sql.append(", ");
            }
            i++;
        }
        sql.append(");");
        //try statement to make sure sql statement gets carried through even if exceptions are found
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql.toString());
            log.info("Table {} created or already exists", name);
        }
    }

    //method for deleting table by asking for table name
    void deleteTable(String name) throws SQLException {
        String sql = String.format("DROP TABLE IF EXISTS%s", name);
        //try statement to make sure the sql statement gets carried through evem if exceptions are found
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            log.info("Table {} deleted if it existed", name);
        }
    }

    public Student getStudentById(int id) throws SQLException {
        String sql = "SELECT * FROM student WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Create Course object from database column
                    Course course = new Course(
                            rs.getString("course_classname"),
                            rs.getInt("course_credits"),
                            rs.getString("course_professor")
                    );
                    //Return Student object including Course
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("email"),
                            course
                    );
                }
            }
        }
        return null; // Student not found
    }

    public Student insertStudent(Student student) throws SQLException {
        //if the user does not give student name or id it does not insert anything
        if (student == null || student.getId() == null) {
            log.warn("Student or student ID is null. Cannot insert.");
            return null;
        }
        //if student with this id already exists it gives warning message
        if (getStudentById(student.getId()) != null) {
            log.warn("Student with ID {} already exists. Cannot insert.", student.getId());
            return null;
        }
       //otherwise it adds student information
        String sql = "INSERT INTO student (id, name, age, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getEmail());
            pstmt.executeUpdate();
            log.info("Inserted student: {}", student);
        }

        return student;
    }

    public void updateStudentById(Integer id, Student newData) throws SQLException {
        //if the user does not provide the old id or the new id it gives warning message
        if (id == null || newData == null) {
            log.warn("ID or new data is null. Cannot update.");
            return;
        }
        //if user provides if that is not already in the system it gives warning message
        if (getStudentById(id) == null) {
            log.warn("Student with ID {} does not exist. Cannot update.", id);
            return;
        }
        //otherwise it updates the info of the student
        String sql = "UPDATE student SET name = ?, age = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newData.getName());
            pstmt.setInt(2, newData.getAge());
            pstmt.setString(3, newData.getEmail());
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            log.info("Updated student with ID {} to {}", id, newData);
        }
    }
    public void deleteStudentById(Integer id) throws SQLException {
       //If user does not provide with id it gives warning
        if (id == null) {
            log.warn("ID is null. Cannot delete student.");
            return;
        }
        //if id provided by user is not valid it gives warning
        if (getStudentById(id) == null) {
            log.warn("Student with ID {} does not exist. Cannot delete.", id);
            return;
        }
        //otherwise it deletes chosen user
        String sql = "DELETE FROM student WHERE id = ?";
        //try statement to make sure code runs even if exceptions are found
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            log.info("Deleted student with ID {}", id);
        }
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Course{
        private String classname;
        private Integer credits;
        private String professor;
    }
    //created student class/table using lombok
    @Data//creates getters and setters
    @NoArgsConstructor//creates empty constructor
    @AllArgsConstructor//creates constructor with all arguments
    public static class Student {
        private Integer id;
        private String name;
        private Integer age;
        private String email;
        private Course course;
    }
}