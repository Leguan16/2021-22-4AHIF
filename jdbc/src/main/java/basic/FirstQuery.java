package basic;

import basic.domain.Student;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class FirstQuery {

    public static void main(String[] args) throws SQLException {
        var students = getStudentsNamedLike();
        System.out.println(students);
    }

    private static Collection<Student> getStudentsNamedLike() throws SQLException {
        var students = new ArrayList<Student>();
        try (var connection = DriverManager.getConnection("jdbc:h2:C:\\h2\\4ahif-db;MV_STORE=false")) {
            var statement = connection.createStatement();
            var sql = """
                    select first_name, id from students
                    where first_name like '%as%'
                    """;
            var resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                var name = resultSet.getString("first_name");
                var id = resultSet.getInt("id");
                var student = new Student(id, name);
                students.add(student);
            }
        }
        return students;
    }
}
