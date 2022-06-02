package app.ui.console.receptionistUI;

import app.controller.receptionistController.ReceptionistController;
import app.controller.snsUserController.SnsUserController;
import app.domain.model.*;

import java.util.List;
import java.util.Scanner;

public class ReceptionistUI implements Runnable{
    private final Company company;
    private final SnsUserController snsuserController;
    private final ReceptionistController receptionistController;
    public ReceptionistUI(Company company) {
        this.company=company;
        this.snsuserController = new SnsUserController(this.company);
        this.receptionistController = new ReceptionistController((this.company));
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
                List<VacCenter> vacCenterList = receptionistController.getVacCenterList();
                if(vacCenterList.isEmpty())
                    System.out.println("No vaccination Centers exist!");
                else{
                    System.out.println("Select a vaccination Center:");
                    int i=0;
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
        int answer = inInt.nextInt();

        switch(answer) {
            case 1:
                System.out.println("Type the user's Vaccination Number");
                int snsNumber = inInt.nextInt();
                UserLastVaccineDTO snsUser = receptionistController.checkIfUserExists(snsNumber);

                if (snsUser == null) {
                    System.out.println("This user does not exist!");
                    answer = 0;
                    break;
                }
                boolean didCheckIn = receptionistController.checkInUser(snsUser,vacCenter);
                if(didCheckIn){
                    System.out.println("This user has been checked-in.");
                }else{
                    System.out.println("This user cannot be checked-in right now.");
                }
                chosenVacCenter(vacCenter);
                break;
            case 2:
                System.out.println("Type the user's Vaccination Number");
                int snsNumber2 = inInt.nextInt();
                UserLastVaccineDTO snsUser2 = receptionistController.checkIfUserExists(snsNumber2);

                if (snsUser2 == null) {
                    System.out.println("This user does not exist!");
                    break;
                }
                boolean didCheckOut = receptionistController.checkOutUser(snsUser2,vacCenter);
                if(didCheckOut){
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
