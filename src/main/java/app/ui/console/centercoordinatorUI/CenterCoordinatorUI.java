package app.ui.console.centercoordinatorUI;

import app.controller.vaccineController.VaccineController;
import app.domain.model.Company;
import app.domain.model.Vaccine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CenterCoordinatorUI implements Runnable{
    Company company;
    public CenterCoordinatorUI(Company company) {
        this.company = company;
    }

    @Override
    public void run() {

        Scanner inInt = new Scanner(System.in);
        System.out.println("1-Get list of Vaccines");
        System.out.println("0-Cancel");
        int option = inInt.nextInt();
        switch (option){
            case 1:
                List<Vaccine> vaccineList;
                List<Vaccine> vaccineList2;
                VaccineController vaccineController = new VaccineController(company);
                vaccineList= vaccineController.getVaccineListOrdered();
                vaccineList2=vaccineController.getVaccineListOrderedByType(vaccineList);
                vaccineController.printList(vaccineList2);

                break;
            case 0: break;
            default:
                System.out.println("Invalid Option");
                run();
        }
    }
}
