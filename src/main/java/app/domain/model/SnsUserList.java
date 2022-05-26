package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class SnsUserList {
    private List<SnsUser> snsUserList = new ArrayList<>();

    public SnsUserList(){

    }

    public SnsUser createsnsUser(int snsNumber, String name, int age, String phoneNumber, String email) {
        SnsUser snsUser = new SnsUser(snsNumber, name, age, phoneNumber, email);
        this.snsUserList.add(snsUser);
        return snsUser;
    }

    public List<SnsUser> listSnsUser() {
        return this.snsUserList;
    }

    public SnsUser getUserBySNSNumber(int snsNumber){
        for (SnsUser user:snsUserList) {
            if(user.getSnsNumber()==snsNumber)
                return user;
        }
        return null;
    }

}
