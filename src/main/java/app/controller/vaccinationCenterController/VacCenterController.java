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

    public void printerVCC(VacCenter vcc) {
        System.out.println(
                "Name: " + vcc.getName() + "\n" +
                        "Address: " + vcc.getAddress() + "\n" +
                        "Phone Number: " + vcc.getPhoneNumber() + "\n" +
                        "Fax: " + vcc.getFaxNumber() + "\n" +
                        "Website: " + vcc.getWebsite() + "\n" +
                        "Opening Hour: " + vcc.getOpeningHour() + "h" + "\n" +
                        "Closing Hour: " + vcc.getClosingHour() + "h" + "\n" +
                        "Slot Duration: " + vcc.getSlotDuration() + "\n" +
                        "Max. of Vaccines: " + vcc.getMaxVaccines() + "\n");
    }
}
