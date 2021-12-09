package basic;

import java.sql.DriverManager;
import java.sql.SQLException;

public class FirstAccess {

    public static void main(String[] args) throws SQLException {
        var connection = DriverManager.getConnection("jdbc:h2:C:\\h2\\4ahif-db;MV_STORE=false");
        var statement = connection.createStatement();
        var sql = """
                insert into students
                (first_name)
                values
                ('Ardian') 
                """;
        var i = statement.executeUpdate(sql);
        System.out.println(i);
        connection.close();
    }
}
