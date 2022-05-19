package app.ui.console.SnsUserUI;

import app.controller.AdminController.AdminController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class loadSnsUserUI implements Runnable{
    @Override
    public void run() {
        Scanner inString = new Scanner(System.in);
        System.out.println("What is the filename");
        String filename = inString.nextLine();
        AdminController adminController = new AdminController();
        try {
            adminController.importFromFile(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
