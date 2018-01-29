package parsing;

import entities.Customer;
import entities.I_Entity;
import exceptions.InvalidInputException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersParser implements I_Parser {

    private List<I_Entity> customers;

    public CustomersParser(File file) {
        customers = new ArrayList<>();
        parseData(file);
    }

    private void parseData(File file) {
        JSONParser parser = new JSONParser();
        try
        {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Object obj = parser.parse(line);
                JSONObject e = (JSONObject) obj;
                Customer customer = new Customer(
                        (String) e.get("name"),
                        ((Long) e.get("user_id")).intValue(),
                        Double.parseDouble((String) e.get("latitude")),
                        Double.parseDouble((String) e.get("longitude"))
                );

                customers.add(customer);
            }
            fileReader.close();
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        catch (InvalidInputException e) {
            e.printStackTrace();
        }

    }

    public List<I_Entity> getData() {
        return customers;
    }
}
