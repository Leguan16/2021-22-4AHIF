package trains.persistence;

import trains.domain.Passenger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class JdbcPassengerRepository implements PassengerRepository {

    private final Connection connection;

    public JdbcPassengerRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Collection<Passenger> findAll() {
        return null;
    }

    @Override
    public Optional<Passenger> findById(Integer id) throws SQLException {
        Objects.requireNonNull(id);
        var sql = """
                select name from passengers
                where id = ?
                """;
        var sqlWithTrain = """
                select passengers.name, trains.name from passengers
                join on trains.name = passengers.train
                where id = ?
                """;
        try (var preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString(1);
                return Optional.of(new Passenger(name));
            } else
                return Optional.empty();
        }
    }

    @Override
    public Passenger save(Passenger passenger) {
        return null;
    }

    @Override
    public Collection<Passenger> findWhereNameContains(String substring) {
        return null;
    }
}
