package sort;

import entities.Customer;
import entities.I_Entity;
import exceptions.InvalidInputException;
import geometry.Coordinate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SortCustomersTest {

    @Test
    public void testCustomerSorting() throws InvalidInputException {
        List<I_Entity> customers = new ArrayList<>();
        customers.add(new Customer("John Murphy", 1, -12.003, 39));
        customers.add(new Customer("Mary Murphy", 1, -12.003, 39));
        customers.add(new Customer("Tom Murphy", 2, -12.003, 39));
        customers.add(new Customer("James Murphy", 2, -12.003, 39));
        customers.add(new Customer("Gerard Murphy", 999999999, -12.003, 39));
        customers.add(new Customer("Bob Murphy", 19, -12.003, 39));
        customers.add(new Customer("Sarah Murphy", 14, -12.003, 39));
        customers.add(new Customer("ASDfalskflajsh Murphy", 1, -12.003, 39));

        int[] ids = new int[customers.size()];
        int[] sortedIds = {1, 1, 1, 2, 2, 14, 19, 999999999};

        SortCustomers sort = new SortCustomers(customers);
        customers = sort.getData();

        for(int i = 0; i < customers.size(); i++) {
            ids[i] = customers.get(i).getId();
        }

        for(int i = 0; i < ids.length; i++) {
            assertEquals(ids[i], sortedIds[i]);
        }
    }

}