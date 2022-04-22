package app.controller.snsUserController;

import app.domain.model.Company;
import app.domain.model.SnsUser;

import java.util.ArrayList;

public class SnsUserController {
    public SnsUser registerUser(int snsNumber, String name, int age, int phoneNumber, String email) {
        Company company = new Company();
        SnsUser snsUser= company.createsnsUser(snsNumber,name,age,phoneNumber,email);
        addUserToList(snsUser);
        return snsUser;
    }

    public void addUserToList(SnsUser snsUser){
        ArrayList snsUserList = new ArrayList();
        snsUserList.add(snsUser);
    }

}
