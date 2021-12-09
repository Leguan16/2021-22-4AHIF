package trains.app;

import trains.persistence.JdbcPassengerRepository;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static final String JDBC_URL = "jdbc:postgres:ifpostgres02:5432/trains";

    public static void main(String[] args) throws SQLException {
        var connection = DriverManager.getConnection(JDBC_URL);
        var passengerRepository = new JdbcPassengerRepository(connection);
    }
}
