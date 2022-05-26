package app.controller.AdminController;

import app.domain.model.Company;
import app.domain.model.SnsUser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminController {

    private final Company company;

    public AdminController(Company company){
        this.company=company;
    }

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
        for (List<String> user: records) {
            this.company.createSnsUser(Integer.parseInt(user.get(0)),
                                        user.get(1),
                                        Integer.parseInt(user.get(2)),
                                        user.get(3),
                                        user.get(4));
        }
        printList();
        return records;
    }

    public void importFromFileWithHeader(String filename) {
    }

    public void printList() {
        for (SnsUser user:this.company.listSnsUser()) {
            System.out.println(user.toString());
        }
    }
}
