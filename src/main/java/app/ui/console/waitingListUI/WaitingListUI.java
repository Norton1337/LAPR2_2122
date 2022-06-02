package app.ui.console.waitingListUI;

import app.controller.vaccinationCenterController.VacCenterController;
import app.controller.waitingList.WaitingListController;
import app.domain.model.Company;
import app.domain.model.UserLastVaccineDTO;
import app.domain.model.VacCenter;

import java.util.List;
import java.util.Scanner;

public class WaitingListUI implements Runnable {

    private final WaitingListController waitingListController;
    private final VacCenterController vacCenterController;
    private final Company company;


    public WaitingListUI( Company company) {

        this.company = company;
        this.waitingListController = new WaitingListController(company);
        this.vacCenterController = new VacCenterController(company);
    }

    public void run(){

        Scanner inInt = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);
        System.out.println("\n\nNurse UI\n\n");
        System.out.println("1-Check users in waiting room");


        int option = inInt.nextInt();
        switch (option){

            case 1:
                List<VacCenter> vacCenterList = vacCenterController.listVacCenters();
                if(vacCenterList.isEmpty())
                    System.out.println("No vaccination centers registered");
                else{
                    System.out.println("Select a vaccination Center:");
                    int i=0;
                    for (VacCenter vacCenter: vacCenterList) {
                        System.out.println("["+i+"] "+vacCenter.getName());
                    }
                    int choice = inInt.nextInt();
                    if(choice>=vacCenterList.size()){
                        System.out.println("Vaccination Center not available");
                    }else{
                        VacCenter center = vacCenterList.get(choice);
                        waitingListController.getVacCenterWaitingList(center);
                        List<UserLastVaccineDTO> usersList = waitingListController.getVacCenterWaitingList(center);
                        for (UserLastVaccineDTO user : usersList){
                            System.out.println(user.getSnsNumber());
                        }
                        break;

                    }
                }
                option = 0;
                break;

        }while (option!=0);
    }

}
