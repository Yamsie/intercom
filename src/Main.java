import config.PropertiesLoader;
import entities.Customer;
import entities.I_Entity;
import exceptions.InvalidInputException;
import formulae.GreatCircleDistance;
import formulae.I_Formula;
import geometry.Coordinate;
import parsing.CustomersParser;
import parsing.I_Parser;
import sort.I_Sort;
import sort.SortCustomers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<I_Entity> validCustomers = new ArrayList<>();
        PropertiesLoader prop = new PropertiesLoader();

        I_Parser parser = new CustomersParser(new File(prop.getProperty("CUSTOMERS_PATH")));
        List<I_Entity> customerList = parser.getData();

        double dublinLatitude = Double.parseDouble(prop.getProperty("DUBLIN_LATITUDE"));
        double dublinLongitude = Double.parseDouble(prop.getProperty("DUBLIN_LONGITUDE"));

        try {
            Coordinate dublinOffice = new Coordinate(dublinLatitude, dublinLongitude);
            I_Formula formula;

            Customer customer;
            for (int i = 0; i < customerList.size(); i++) {
                customer = (Customer) customerList.get(i);
                Coordinate customerCoordinate = customer.getCoordinates();
                formula = new GreatCircleDistance(dublinOffice, customerCoordinate);

                if (formula.getResult() <= 100) {
                    validCustomers.add(customer);
                }
            }

            I_Sort sort = new SortCustomers(validCustomers);
            validCustomers = sort.getData();

            for (int i = 0; i < validCustomers.size(); i++) {
                customer = (Customer) validCustomers.get(i);
                System.out.println("Name: " + customer.getName() + " | ID: " + customer.getId());
            }
        }
        catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}
