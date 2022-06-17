package app.domain.store;

import app.domain.model.numberOfPeopleVaccinated;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class numberOfPeopleVaccinatedStore {
    List<numberOfPeopleVaccinated> nopvList = new ArrayList<>();


    public boolean saveNumberOfPeopleVaccinatedPerCenter(numberOfPeopleVaccinated nopv){
        return this.nopvList.add(nopv);
    }

    public List<numberOfPeopleVaccinated> getNumberOfPeopleVaccinatedPerCenter(){
        return new ArrayList<>(this.nopvList);
    }


    public boolean sendDataToCSV() {
        try {
            FileWriter fWriter = new FileWriter("NumberOfPeopleVaccinated.csv", true);
            BufferedWriter bw = new BufferedWriter(fWriter);
            PrintWriter out = new PrintWriter(bw);

            String pattern = "dd/MM/yyyy";
            DateFormat dateFormat = new SimpleDateFormat(pattern);

            for(numberOfPeopleVaccinated nopv : nopvList) {
                out.printf("%s, %s, %d\n", dateFormat.format(nopv.getDate()), nopv.getVacCenterName(), nopv.getNVaccinations());
            }

            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
