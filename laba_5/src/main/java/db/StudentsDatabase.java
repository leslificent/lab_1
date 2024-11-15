package db;

import db.dto.StudentDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class StudentsDatabase {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "11111111";

    public List<StudentDTO> getStudentsFromDatabase() {
        List<StudentDTO> students = new ArrayList<>();

        String query = "SELECT id, last_name, first_name, middle_name, birth_date, record_book_number FROM students";

        try (
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                Date birthDate = resultSet.getDate("birth_date");
                String recordBookNumber = resultSet.getString("record_book_number");

                StudentDTO student = new StudentDTO(id, lastName, firstName, middleName, birthDate, recordBookNumber);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
