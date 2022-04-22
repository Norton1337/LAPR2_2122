package app.ui.console.SnsUserUI;

import app.controller.snsUserController.SnsUserController;
import app.domain.model.SnsUser;

import java.util.Scanner;

public class RegisterSNSUserUI implements Runnable{

    @Override
    public void run() {

            SnsUserController snsuserController = new SnsUserController();
            Scanner inInt = new Scanner(System.in);
            Scanner inString = new Scanner(System.in);
            System.out.println("\n\n RECEPTIONIST UI\n\n");
            System.out.println("1-Register a new SNS user");
            System.out.println("0-Cancel");
            int option = inInt.nextInt();
            switch(option) {
                    case 1:
                            System.out.println("Whats the User sns number?");
                            int snsNumber = inInt.nextInt();
                            System.out.println("Whats the SNS user name?");
                            String name = inString.nextLine();
                            System.out.println("Whats the SNS user age?");
                            int age = inInt.nextInt();
                            System.out.println("Whats the SNS user phone number?");
                            int phoneNumber = inInt.nextInt();
                            System.out.println("Whats the SNS user email address?");
                            String email = inString.nextLine();
                            SnsUser user = snsuserController.registerUser(snsNumber, name, age, phoneNumber, email);
                            System.out.println(user);
                            System.out.println("User registered succesfully");
                            break;
            }while (option!=0);


    }
}
