package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class VacCenterList {
    private final List<VacCenter> vacCenterList;

    public VacCenterList(){
        vacCenterList = new ArrayList<>();
    }

    public VacCenter createVaccinationCenter(String name, String address, String phoneNumber, String faxNumber, String website, int openingHour, int closingHour, int slotDuration, int maxVaccines) {
        VacCenter vacCenter = new VacCenter(name, address, phoneNumber, faxNumber, website, openingHour, closingHour, slotDuration, maxVaccines);
        vacCenterList.add(vacCenter);
        return vacCenter;
    }

    public List<VacCenter> showAllVacCenters() {
        return this.vacCenterList;
    }

}
