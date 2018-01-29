package entities;

import exceptions.InvalidInputException;
import geometry.Coordinate;

public class Customer implements I_Entity {

    private String name;
    private int userId;
    private Coordinate coordinates;

    public Customer(String name, int userId, double latitude, double longitude) throws InvalidInputException {

        if (!name.matches("^[\\p{L} .'-]+$")) {
            throw new InvalidInputException("Invalid name: " + name);
        }

        if (userId <= 0) {
            throw new InvalidInputException("Invalid User ID: " + userId);
        }

        this.name = name;
        this.userId = userId;

        coordinates = new Coordinate(latitude, longitude);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return userId;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }
}
