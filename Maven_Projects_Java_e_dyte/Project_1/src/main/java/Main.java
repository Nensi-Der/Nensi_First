import java.sql.*;
public class Main
{
    String url =  "jdbc:postgresql://localhost:5432/INTERNSHIP";
    String user = "postgres";
    String password = "Nender798/";
    public static void main(String[] args)
    {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/INTERNSHIP", "postgres", "Nender798/")) {

            // Pika a
            System.out.println("a) Tables in database:");
            String sqlTables = "SELECT student FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlTables)) {
                while (rs.next()) {
                    System.out.println("- " + rs.getString("student"));
                }
            }
            sqlTables = "SELECT kursi FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlTables)) {
                while (rs.next()) {
                    System.out.println("- " + rs.getString("kursi"));
                }
            }

            // Pika b
            System.out.println("\nb) Rows from 'kursi' table:");
            String sqlKursi = "SELECT * FROM kursi";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlKursi)) {
                ResultSetMetaData meta = rs.getMetaData();
                int columns = meta.getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= columns; i++) {
                        System.out.print(meta.getColumnName(i) + "=" + rs.getString(i) + " ");
                    }
                    System.out.println();
                }
            }

            // Pika c
            System.out.println("\nc) Students with more than 10 points:");
            String sqlStudents = "SELECT * FROM student WHERE piket > 10";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlStudents)) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("emri") + ", Points: " + rs.getInt("piket"));
                }
            }

            // Pika d
            System.out.println("\nd) Insert nje student te ri: ");
            String sqlInsert = "INSERT INTO student (emri, email, birth_date, phone_number, pike, internship_id) VALUES (?, ?, ?, ?, ? ,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
                pstmt.setString(1, "s");
                pstmt.setString(2, "s@gmail.com");
                pstmt.setDate(3, java.sql.Date.valueOf("1990-05-21"));
                pstmt.setInt(4, 060);
                pstmt.setInt(5, 10);
                pstmt.setInt(6, 1);
                int rowsInserted = pstmt.executeUpdate();
                System.out.println("Inserted rows: " + rowsInserted);
            }

            // Pika e
            System.out.println("\ne) Update piket e studenteve me ID 2: ");
            String sqlUpdate = "UPDATE student SET piket = 30 WHERE id 2 ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
                pstmt.setInt(1, 30);
                pstmt.setInt(2, 2);
                int rowsUpdated = pstmt.executeUpdate();
                System.out.println("Updated rows: " + rowsUpdated);
            }

            //Pika f
            System.out.println("\nf) Fshi studentet me me pak se 10 pike: ");
            String sqlDelete = "DELETE FROM student WHERE id < 10 ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
                pstmt.setInt(1, 10);
                int rowsDeleted = pstmt.executeUpdate();
                System.out.println("Deleted rows: " + rowsDeleted);
            }

        } catch (SQLException e) {
            e.printStackTrace();}

        }
    }

