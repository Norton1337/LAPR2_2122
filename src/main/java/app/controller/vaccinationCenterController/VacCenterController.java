package app.controller.vaccinationCenterController;


import app.domain.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public void exportStatistics(LocalDate localDate, LocalDate localDate2) throws FileNotFoundException {
        List<SnsUser> snsUsers = this.company.listSnsUser();
        List<FullVaccinationDTO> fullyVaccinated = new ArrayList<>();
        for (SnsUser snsUser: snsUsers) {
            if(!snsUser.getUserVaccines().getUserVaccinesDto().isEmpty()){
                for (UserVaccinesDTO userVaccine: snsUser.getUserVaccines().getUserVaccinesDto()) {
                    if(userVaccine.endedVaccination()){
                        LocalDate userLastDoseDate = userVaccine.lastDoseDate().toLocalDate();
                        if(userLastDoseDate.isAfter(localDate)&&userLastDoseDate.isBefore(localDate2))
                            fullyVaccinated.add(new FullVaccinationDTO(snsUser.getSnsNumber(),userVaccine.lastDoseDate().toLocalDate()));
                    }
                }
            }
        }
        treatData(fullyVaccinated);
    }

    private void treatData(List<FullVaccinationDTO> fullyVaccinated) throws FileNotFoundException {
        List<LocalDate> differentDates = new ArrayList<>();
        for (FullVaccinationDTO vac:fullyVaccinated) {
            if(!differentDates.contains(vac.dateOfFullVaccination)) {
                differentDates.add(vac.dateOfFullVaccination);
            }
        }
        List<Integer> amountPerDate = new ArrayList<>();
        for (int i=0;i<differentDates.size();i++) {
            amountPerDate.add(0);
            for (FullVaccinationDTO vac:fullyVaccinated) {
                if(differentDates.contains(vac.dateOfFullVaccination)) {
                    amountPerDate.set(i,amountPerDate.get(i)+1);
                }
            }
        }
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        PrintWriter pw = new PrintWriter(new File(dir+"/src/main/resources/files/newFile.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("date");
        sb.append(",");
        sb.append("amount of users");

        sb.append("\r\n");
        int i=0;
        for (LocalDate date:differentDates) {
            sb.append(date.toString());
            sb.append(",");
            sb.append(amountPerDate.get(i));
            sb.append("\r\n");
            i++;
        }

        pw.write(sb.toString());
        pw.close();
    }
}
