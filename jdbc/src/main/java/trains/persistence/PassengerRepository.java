package trains.persistence;

import trains.domain.Passenger;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public interface PassengerRepository {

    Collection<Passenger> findAll();

    Optional<Passenger> findById(Integer id) throws SQLException;

    /**
     * Saves the passenger
     *
     * @param passenger passenger to save
     * @return passenger with added information
     */
    Passenger save(Passenger passenger);

    Collection<Passenger> findWhereNameContains(String substring);
}
