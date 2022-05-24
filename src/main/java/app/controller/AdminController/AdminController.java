package app.controller.AdminController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminController {
    public List importFromFile(String filename) throws FileNotFoundException {
        boolean header= true ;
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (header &&  !(values[0].indexOf(0)<= 9 && values[0].indexOf(0) >= 0))
                    header = false;
                else records.add(Arrays.asList(values));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printList(records);
        return records;
    }

    public void importFromFileWithHeader(String filename) {
    }

    public void printList(List users) {
        for(int i= 0; i<users.size();i++){
            System.out.println(users.get(i));
        }
    }
}
