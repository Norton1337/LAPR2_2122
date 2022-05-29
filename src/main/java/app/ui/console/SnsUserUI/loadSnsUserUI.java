package app.ui.console.SnsUserUI;

import app.controller.AdminController.AdminController;
import app.domain.model.Company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class loadSnsUserUI implements Runnable{
    Company company;

    public loadSnsUserUI(Company company){
        this.company=company;
    }

    @Override
    public void run() {
        Scanner inString = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);
        System.out.println("What is the filename");
        String filename = inString.nextLine();
        System.out.println("Your file has an header?");
        System.out.println("1-Yes");
        System.out.println("2-No");
        int option = inInt.nextInt();
        AdminController adminController = new AdminController(company);
        try {
            adminController.importFromFile(filename,option);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
