package app.controller.vaccinationCenterController;


import app.domain.model.Company;
import app.domain.model.VacCenter;

import java.util.List;

public class VacCenterController {


    private Company company;
    public VacCenterController(Company company) {
        this.company=company;
    }

    public VacCenter registerVC(String name, String address, String phoneNumber, String faxNumber, String website, int openingHour, int closingHour, int slotDuration, int maxVaccines) {
        return company.getVacCenterList().createVaccinationCenter(name, address, phoneNumber, faxNumber, website, openingHour, closingHour, slotDuration, maxVaccines);
    }

    public List<VacCenter> listVacCenters(){
        return company.getVacCenterList().showAllVacCenters();
    }
}
