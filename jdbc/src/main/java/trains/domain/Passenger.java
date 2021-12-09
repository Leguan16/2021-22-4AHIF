package trains.domain;

public class Passenger {

    private Integer id;
    private String name;
    private Train train;

    public Passenger(String name) {
        this.name = name;
    }
}
