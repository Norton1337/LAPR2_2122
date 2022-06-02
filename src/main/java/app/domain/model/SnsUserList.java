package app.domain.model;

import app.ui.console.SnsUserUI.RegisterSNSUserUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnsUserList {
    private List<SnsUser> snsUserList = new ArrayList<>();
    public SnsUserList(){
    }

    public SnsUser createSnsUser(int snsNumber, String name, int age, String phoneNumber, String email) {
        SnsUser snsUser = new SnsUser(snsNumber, name, age, phoneNumber, email);
        this.snsUserList.add(snsUser);
        return snsUser;
    }

    public List<SnsUser> listSnsUser() {
        return this.snsUserList;
    }

    public SnsUser getUserBySNSNumber(int snsNumber){

        if (snsUserList.isEmpty()) {
            Scanner inInt = new Scanner(System.in);
            Scanner inString = new Scanner(System.in);

            System.out.println("Insert your name:");
            String name = inString.nextLine();
            System.out.println("Whats the SNS user age?");
            int age = inInt.nextInt();
            System.out.println("Whats the SNS user phone number?");
            String phoneNumber = inString.nextLine();
            System.out.println("Whats the SNS user email address?");
            String email = inString.nextLine();
            createSnsUser(snsNumber, name, age, phoneNumber, email);
        }

        for (SnsUser user : snsUserList) {
            if(user.getSnsNumber()==snsNumber) {
                return user;
            }
        }
        return null;
    }

}
