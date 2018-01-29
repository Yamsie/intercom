package entities;

import exceptions.InvalidInputException;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {

    @Test
    public void testNameNormal() throws InvalidInputException {
        Customer cust1 = new Customer("John Murphy", 1, -12.003, 39);
        assertNotNull(cust1);

    }

    @Test
    public void testNameApostropheNumeric() throws InvalidInputException {
        Customer cust2 = new Customer("khhMMM''l", 4, 0000000000, 0000000000);
        assertNotNull(cust2);
    }

    @Test
    public void testZeroId() throws InvalidInputException {
        org.junit.jupiter.api.function.Executable err1 = () -> {
            Customer cust3 = new Customer("John Murphy", 0, -12.003, 39);
        };

        assertThrows(InvalidInputException.class, err1);
    }

    @Test
    public void testEmptyName() throws InvalidInputException {
        org.junit.jupiter.api.function.Executable err1 = () -> {
            Customer cust4 = new Customer("", 193884, -20, 80);
        };

        assertThrows(InvalidInputException.class, err1);
    }

    @Test
    public void testAlphaNumeric() throws InvalidInputException {
        org.junit.jupiter.api.function.Executable err1 = () -> {
            Customer cust5 = new Customer("b123123123", 23665, 1, 1);
        };

        assertThrows(InvalidInputException.class, err1);
    }

    @Test
    public void testNegativeId() throws InvalidInputException {
        org.junit.jupiter.api.function.Executable err1 = () -> {
            Customer cust2 = new Customer("hello", -4, 0000000000, 0000000000);
        };

        assertThrows(InvalidInputException.class, err1);
    }

}