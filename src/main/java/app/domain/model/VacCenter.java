package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class VacCenter {
    private String name;
    private String address;
    private String phoneNumber;
    private String faxNumber;
    private String website;
    private int openingHour;
    private int closingHour;
    private int slotDuration;
    private int maxVaccines; // max no. of vaccines that can be given per slot
    private List <Employee> employeeList = new ArrayList<>();

    public VacCenter(String name, String address, String phoneNumber, String faxNumber, String website, int openingHour, int closingHour, int slotDuration, int maxVaccines) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.website = website;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.slotDuration = slotDuration;
        this.maxVaccines = maxVaccines;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public int getSlotDuration() {
        return slotDuration;
    }

    public int getMaxVaccines() {
        return maxVaccines;
    }

}
