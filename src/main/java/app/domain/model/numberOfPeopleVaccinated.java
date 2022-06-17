package app.domain.model;

import app.controller.vaccinationCenterController.VacCenterController;

import java.util.Date;
import java.util.List;

public class numberOfPeopleVaccinated {
    private static Date date;
    private int nVaccinations;
    private String vacCenterName;

    private Company company;
    private int numberVaccinations;

    public numberOfPeopleVaccinated(Date date, int nVaccinations, String vacCenterName, Company company){
        this.company= company;
        this.date = date;
        this.nVaccinations = nVaccinations;
        this.vacCenterName = vacCenterName;
    }
    public numberOfPeopleVaccinated(){
    }

    public static Date getDate() {
        return date;
    }

    public int getNVaccinations() {
        return nVaccinations;
    }

    public String getVacCenterName() {
        return vacCenterName;
    }

    public int saveNumberOfPeopleVaccinatedPerCenter(numberOfPeopleVaccinated numberVaccinations) {
        VacCenterController vacc = new VacCenterController(company);
        return vacc.fullSNSUserVaccination().size();
    }


        public void sendDataToCSV() {
    }
}
