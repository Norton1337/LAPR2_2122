package app.domain.model;

import app.controller.vaccinationCenterController.VacCenterController;

import java.util.Date;

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

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public String sendDataToCSV() {
       /* return Stream.of(numberOfVaccinations)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));

        */
        return null;
    }


}
