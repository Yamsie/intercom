package geometry;

import exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CoordinateTest {

    @Test
    public void testLongitudeBoundariesPosPos() throws InvalidInputException {
        org.junit.jupiter.api.function.Executable err = () -> {
            Coordinate coordinate1 = new Coordinate(90.0001, 180.0001);
        };

        Coordinate coordinate2 = new Coordinate(89.9999, 179.9999);


        assertThrows(InvalidInputException.class, err);
        assertNotNull(coordinate2);
    }

    @Test
    public void testLongitudeBoundariesPosNeg() throws InvalidInputException {
        org.junit.jupiter.api.function.Executable err = () -> {
            Coordinate coordinate = new Coordinate(90.0001, -180.0001);
        };

        Coordinate coordinate2 = new Coordinate(89.9999, -179.9999);


        assertThrows(InvalidInputException.class, err);
        assertNotNull(coordinate2);
    }

    @Test
    public void testLongitudeBoundariesNegPos() throws InvalidInputException {
        org.junit.jupiter.api.function.Executable err = () -> {
            Coordinate coordinate = new Coordinate(-90.0001, 180.0001);
        };

        Coordinate coordinate2 = new Coordinate(-89.9999, 179.9999);

        assertThrows(InvalidInputException.class, err);
        assertNotNull(coordinate2);
    }

    @Test
    public void testLongitudeBoundariesNegNeg() throws InvalidInputException {
        org.junit.jupiter.api.function.Executable err = () -> {
            Coordinate coordinate = new Coordinate(-90.0001, -180.0001);
        };

        Coordinate coordinate2 = new Coordinate(-89.9999, -179.9999);

        assertThrows(InvalidInputException.class, err);
        assertNotNull(coordinate2);
    }

}