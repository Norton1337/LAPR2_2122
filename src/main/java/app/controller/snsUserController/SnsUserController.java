package app.controller.snsUserController;

import app.domain.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnsUserController {
    Company company;
    Map<Integer, String> vacMap = new HashMap<>();
    public SnsUserController(Company company) {
        this.company=company;
    }

    public SnsUser registerUser(int snsNumber, String name, int age, String phoneNumber, String email) {

        SnsUser snsUser= company.createSnsUser(snsNumber,name,age,phoneNumber,email);
        addUserToList(snsUser);
        return snsUser;
    }

    private void addUserToList(SnsUser snsUser){
        ArrayList snsUserList = new ArrayList();
        snsUserList.add(snsUser);

    }

    public List<VacCenter> getVacCenterList(){
        return this.company.getVacCenterList().showAllVacCenters();
    }

  /*  public void printUsers(ArrayList snsUserList){
        for(int i=0; i<=snsUserList.size();i++ ) {
            System.out.println(snsUserList.get(i));
        }
    }
*/
}
