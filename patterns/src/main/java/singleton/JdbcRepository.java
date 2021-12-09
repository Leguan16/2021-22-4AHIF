package singleton;

import java.sql.Connection;

public class JdbcRepository {

    private static JdbcRepository instance;
    private Connection connection;

    private JdbcRepository(Connection connection) {
        this.connection = connection;
    }

    public static JdbcRepository instance(Connection connection) {
        if (instance == null)
            instance = new JdbcRepository(connection);
        return instance;
    }
}
