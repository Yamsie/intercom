package sort;

import entities.I_Entity;

import java.util.Collections;
import java.util.List;

public class SortCustomers implements I_Sort {

    private List<I_Entity> customers;

    public SortCustomers(List<I_Entity> customers) {
        this.customers = customers;
        doSort();
    }

    private void doSort() {
        Collections.sort(customers, (customer1, customer2) -> {
            Integer id1 = customer1.getId();
            Integer id2 = customer2.getId();
            return id1.compareTo(id2);
        });
    }

    public List<I_Entity> getData() {
        return customers;
    }
}
