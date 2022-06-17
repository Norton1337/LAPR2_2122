package app.controller.vaccinationCenterController;


import app.domain.model.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VacCenterController {

    private final Company company;
    List<FullVaccinationDTO> fullyVaccinated = new ArrayList<>();

    public VacCenterController(Company company) {
        this.company=company;
    }

    public VacCenter registerVC(String name, String address, String phoneNumber, String faxNumber, String website, int openingHour, int closingHour, int slotDuration, int maxVaccines) {
        return company.getVacCenterList().createVaccinationCenter(name, address, phoneNumber, faxNumber, website, openingHour, closingHour, slotDuration, maxVaccines);
    }

    public List<VacCenter> listVacCenters(){
        return company.getVacCenterList().showAllVacCenters();
    }

    public List<VacCenter> listVacCentersString(){
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


    public List<FullVaccinationDTO> getFullyVaccinated(LocalDate localDate, LocalDate localDate2){
         return this.company.getFullyVaccinated(localDate,localDate2);
    }

    public List<FullVaccinationDTO> fullSNSUserVaccination(){
        return fullyVaccinated;
    }

    public void treatVaccinationData(List<FullVaccinationDTO> fullVaccinationDTOS,LocalDate localDate, LocalDate localDate2) throws FileNotFoundException {
        FileCreator.treatVaccinationData(fullVaccinationDTOS, localDate, localDate2);
    }


}
