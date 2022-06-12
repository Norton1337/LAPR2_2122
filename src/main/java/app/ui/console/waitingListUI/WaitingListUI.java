package app.ui.console.waitingListUI;

import app.controller.vaccinationCenterController.VacCenterController;
import app.controller.waitingList.WaitingListController;
import app.domain.model.Company;
import app.domain.model.UserLastVaccineDTO;
import app.domain.model.VacCenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaitingListUI implements Runnable {

    private final WaitingListController waitingListController;
    private final VacCenterController vacCenterController;
    private final Company company;
    private final List<String> adverseReactionList = new ArrayList<>();


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
        System.out.println("2- Register adverse reaction");
        System.out.println("3- Check all adverse reactions");
        System.out.println("4- Record vaccine administration");


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
            case 2:
                 vacCenterList = vacCenterController.listVacCenters();
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
                            System.out.println(i+1 + "-" + user.getSnsNumber()+" "+ user.getName());
                        }
                        if(center.waitingRoom().isEmpty()){
                            System.out.println("waiting room empty");
                        }else{
                        System.out.println("Which sns user had an adverse reaction?");
                        int snsUserOption = inInt.nextInt();
                        if(snsUserOption-1 > usersList.size()){
                            System.out.println("invalid option");
                        }
                        usersList.get(snsUserOption-1);
                        System.out.println("Describe the simptoms");
                        String description = inString.nextLine();
                        adverseReactionList.add(String.valueOf(usersList.get(snsUserOption-1)));
                        adverseReactionList.add(description);
                        System.out.println("Registered Sucessfully");
                        usersList.remove(snsUserOption-1);
                        }

                        option = 0;
                        break;
                    }
                } case 3:
                    if(adverseReactionList.isEmpty()){
                        System.out.println("There's no adverse reactions registered yet.");
                        break;
                    }else{
                        for (int i = 0; i < adverseReactionList.size(); i++) {
                            System.out.println("User:"+ adverseReactionList.get(i) + "Reactions:" + adverseReactionList.get(i+1));
                            i++;
                        }
                        break;
                    }
        }while (option!=0);
    }

}
