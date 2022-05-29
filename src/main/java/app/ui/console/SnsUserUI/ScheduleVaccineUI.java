package app.ui.console.SnsUserUI;

import app.controller.snsUserController.SnsUserController;
import app.controller.vaccinationCenterController.VacCenterController;
import app.controller.vaccineController.VaccineController;
import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScheduleVaccineUI implements Runnable{

    private static final String SEPARATOR_LABEL = "-------------------------------------------------------------";
    private List<Vaccine> vaccineList;

    Company company;
    SnsUserController snsuserController;
    VacCenterController vacCenterController;
    VaccineController vaccineController;
    //ScheduleVaccineController scheduleVaccineController;

    public ScheduleVaccineUI(Company company) {
        this.company=company;
        this.snsuserController = new SnsUserController(this.company);
        this.vacCenterController = new VacCenterController(this.company);
        this.vaccineController = new VaccineController(this.company);

        vaccineList=new ArrayList<>();
        //this.scheduleVaccineController = new ScheduleVaccineController(this.company);
    }

    @Override
    public void run() {
        Scanner inInt = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);
        System.out.println("\n\n USER UI\n\n");
        System.out.println("1-Schedule a Vaccine");
        System.out.println("0-Cancel");
        int option = inInt.nextInt();
        switch(option) {
            case 1:
                System.out.println("SNS Number: ");
                int snsNumber = inInt.nextInt();
                if (company.getUserBySNSNumber(snsNumber) == null) {
                    break;
                } else {

                    //list of Vaccination Centers
                    List<VacCenter> vcclist = snsuserController.getVacCenterList();
                    if (vcclist.isEmpty()) {
                        System.out.println("You need to enter vaccination centers to proceed");

                        option = 0;
                        break;
                    }
                    System.out.println(SEPARATOR_LABEL);
                    System.out.println("                Select a Vaccination Center ");
                    System.out.println(SEPARATOR_LABEL);

                    int i = 0;
                    for (VacCenter vacCenter : vcclist) {
                        System.out.println("[" + i + "]" + vacCenter.getName());
                    }

                    int center = inInt.nextInt();

                    if (center > vcclist.size()) {
                        System.out.println("Vaccination Center doesn't exist! Please try again.");
                    }


                    //list of Vaccine Types
                    List<VaccineType> vlist = vaccineController.listVaccineTypes();

                    if (vlist.isEmpty()) {
                        System.out.println("You need to enter vaccine types to proceed.");

                        option = 0;
                        break;
                    }
                    System.out.println(SEPARATOR_LABEL);
                    System.out.println("                Select a Vaccine ");
                    System.out.println(SEPARATOR_LABEL);

                    for (VaccineType vac : vlist) {
                        System.out.println(vac.getDisease());
                    }

                    System.out.println("Choose a Vaccine Type:");
                    String choose = inString.nextLine();

                    for (SnsUser user : company.listSnsUser()) {
                        if (user.getSnsNumber() == snsNumber) {
                            verifyVaccineType(choose);
                        }
                    }
                }

                option = 0;
                break;
            case 0:
                break;
        }
    }

    private void verifyVaccineType(String vacType) {
        List<VaccineType> vlist = vaccineController.listVaccineTypes();
        for(VaccineType vaccineType : vlist) {
            if(vaccineType.getDisease().equals(vacType)){
                System.out.println("It is not possible to choose the same vaccine. Please try again.");
                break;
            }
        }
    }

}
