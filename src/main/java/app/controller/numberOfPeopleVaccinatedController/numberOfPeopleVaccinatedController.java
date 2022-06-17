package app.controller.numberOfPeopleVaccinatedController;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.numberOfPeopleVaccinated;
import app.domain.model.VacCenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class numberOfPeopleVaccinatedController extends TimerTask {
    private final Company company;



    public numberOfPeopleVaccinatedController(){
        this.company = App.getInstance().getCompany();
    }

    @Override
    public void run() {
        final String state = "TAKEN";
        List<VacCenter> vacCenterList = getVaccinationCenters();
        List<VacCenter> vaccEventList = new ArrayList<>();


        String pattern = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String dateInString = dateFormat.format(new Date());

        int count = 0;
        String vacCenterName;
        for (VacCenter vaccCenter : vacCenterList) {

            vacCenterName = vaccCenter.getName();
            vaccEventList.addAll((Collection<? extends VacCenter>) vaccCenter);

            for (VacCenter vacCenter : vaccEventList) {
                LocalDate date = LocalDate.parse(dateInString);
                if (numberOfPeopleVaccinated.getDate().equals(date)) {
                    count++;
                }
            }
            addNumberOfVaccinationsPerCenter(new Date(), count, vacCenterName);
            count = 0;
        }

        int numberOfVaccinations = getNOPVPerCenter();

        sendDataToCSV();
    }







    public List<VacCenter> getVaccinationCenters() {
        return this.company.getVacCenterList().showAllVacCenters();
    }


    public void addNumberOfVaccinationsPerCenter(Date date, int nVaccinations, String centerName){
        numberOfPeopleVaccinated numberVaccinations = new numberOfPeopleVaccinated(date, nVaccinations, centerName,company);
        company.getNOPVStore().saveNumberOfPeopleVaccinatedPerCenter(numberVaccinations);
    }


    public int getNOPVPerCenter(){
        numberOfPeopleVaccinated numberVaccinations = new numberOfPeopleVaccinated();
        return this.company.getNOPVStore().saveNumberOfPeopleVaccinatedPerCenter(numberVaccinations);
    }


    public void sendDataToCSV(){
        this.company.getNOPVStore().sendDataToCSV();
    }


}
