package singleton;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        var connection = DriverManager.getConnection("jdbc:h2:mem:nope");
        System.out.println(JdbcRepository.instance(connection) == JdbcRepository.instance(connection));
    }
}
