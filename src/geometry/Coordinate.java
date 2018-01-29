package geometry;

import exceptions.InvalidInputException;

public class Coordinate {

    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) throws InvalidInputException{
        if (longitude < -180 || longitude > 180) {
            throw new InvalidInputException("Invalid longitude: " + longitude);
        }
        if (latitude < -90 || latitude > 90) {
            throw new InvalidInputException("Invalid latitude: " + latitude);
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
