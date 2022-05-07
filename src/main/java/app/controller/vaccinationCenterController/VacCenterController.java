package app.controller.vaccinationCenterController;


import app.domain.model.VacCenter;

import java.util.List;

public class VacCenterController {

    private final VacCenter vacCenter;

    public VacCenterController() {
        this.vacCenter = new VacCenter();
    }

    public VacCenter registerVC(String name, String address, String phoneNumber, String faxNumber, String website, int openingHour, int closingHour, int slotDuration, int maxVaccines) {
        return vacCenter.createVaccinationCenter(name, address, phoneNumber, faxNumber, website, openingHour, closingHour, slotDuration, maxVaccines);
    }

    public List<VacCenter> listVacCenters(){
        return vacCenter.showAllVacCenters();
    }
}
