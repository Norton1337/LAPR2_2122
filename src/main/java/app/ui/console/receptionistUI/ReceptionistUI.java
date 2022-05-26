package app.ui.console.receptionistUI;

import app.controller.snsUserController.SnsUserController;
import app.domain.model.Company;
import app.domain.model.SnsUser;
import app.domain.model.VacCenter;
import app.domain.model.WaitingRoom;

import java.util.List;
import java.util.Scanner;

public class ReceptionistUI implements Runnable{
    Company company;
    SnsUserController snsuserController;
    public ReceptionistUI(Company company) {
        this.company=company;
        this.snsuserController = new SnsUserController(this.company);
    }

    @Override
    public void run() {


        Scanner inInt = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);
        System.out.println("\n\n RECEPTIONIST UI\n\n");
        System.out.println("1-Choose Vaccination Center");
        System.out.println("2-Register a new SNS user");
        System.out.println("0-Cancel");
        int option = inInt.nextInt();
        switch(option) {
            case 1:

                if(this.company.showAllVacCenters().isEmpty())
                    System.out.println("No vaccination Centers exist!");
                else{
                    System.out.println("Select a vaccination Center:");
                    int i=0;
                    List<VacCenter> vacCenterList = this.company.showAllVacCenters();
                    for (VacCenter vacCenter: vacCenterList) {
                        System.out.println("["+i+"] "+vacCenter.getName());
                    }
                    int choice = inInt.nextInt();
                    if(choice>=vacCenterList.size()){
                        System.out.println("Vaccination Center doesn't exist!");
                    }else{
                        chosenVacCenter(vacCenterList.get(choice));
                    }
                }

                run();
                break;
            case 2:
                System.out.println("Whats the User sns number?");
                int snsNumber = inInt.nextInt();
                System.out.println("Whats the SNS user name?");
                String name = inString.nextLine();
                System.out.println("Whats the SNS user age?");
                int age = inInt.nextInt();
                System.out.println("Whats the SNS user phone number?");
                String phoneNumber = inString.nextLine();
                System.out.println("Whats the SNS user email address?");
                String email = inString.nextLine();
                SnsUser user = snsuserController.registerUser(snsNumber, name, age, phoneNumber, email);
                System.out.println(user);
                System.out.println("User registered succesfully");
                run();
                break;
            case 0: break;
        }

    }

    private void chosenVacCenter(VacCenter vacCenter){
        String vacCenterName = vacCenter.getName();
        Scanner inInt = new Scanner(System.in);
        System.out.println("\n\n "+vacCenterName+" UI\n\n");
        System.out.println("1-Check-In SNSUser");
        System.out.println("2-Check-Out SNSUser");
        System.out.println("0-Cancel");
        int option = inInt.nextInt();
        WaitingRoom waitingRoom= vacCenter.getWaitingRoom();
        System.out.println("Type the user's Vaccination Number");
        int snsNumber = inInt.nextInt();
        SnsUser snsUser = this.company.getSnsUserList().getUserBySNSNumber(snsNumber);
        if(snsUser==null){
            System.out.println("This user does not exist!");
            option=0;
        }
        switch(option) {
            case 1:

                if(waitingRoom.checkInSnsUser(snsUser)){
                    System.out.println("This user has been checked-out.");
                }else{
                    System.out.println("This user cannot be checked-out right now.");
                }
                chosenVacCenter(vacCenter);
                break;
            case 2:

                if(waitingRoom.checkOutSnsUser(snsUser)){
                    System.out.println("This user has been checked-out.");
                }else{
                    System.out.println("This user cannot be checked-out right now.");
                }
                chosenVacCenter(vacCenter);
                break;
            case 0: break;
        }

    }
}
