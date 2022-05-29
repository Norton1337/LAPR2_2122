package app.domain.model;

import java.util.Objects;

public class SnsUser {
    private int snsNumber;
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private UserVaccines userVaccines;
    public SnsUser(int snsNumber, String name, int age, String phoneNumber, String email) {

        this.snsNumber = snsNumber;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userVaccines = new UserVaccines();
    }

    public int getSnsNumber() {
        return snsNumber;
    }

    public void setSnsNumber(int snsNumber) {
        this.snsNumber = snsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserVaccines getUserVaccines(){
        return this.userVaccines;
    }

    @Override
    public String toString() {
        return "SnsUser{" +
                "snsNumber=" + snsNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }


}
