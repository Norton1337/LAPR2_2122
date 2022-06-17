package app.domain.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileCreator {
    public static void treatVaccinationData(List<FullVaccinationDTO> fullVaccinationDTOS, LocalDate localDate, LocalDate localDate2) throws FileNotFoundException {
        List<LocalDate> differentDates = new ArrayList<>();

        for (FullVaccinationDTO vac:fullVaccinationDTOS) {
            if(!differentDates.contains(vac.dateOfFullVaccination)) {
                differentDates.add(vac.dateOfFullVaccination);
            }
        }
        differentDates.sort(Comparator.comparing(LocalDate::atStartOfDay));
        List<Integer> amountPerDate = new ArrayList<>();
        for (int i=0;i<differentDates.size();i++) {
            amountPerDate.add(0);
            for (FullVaccinationDTO vac:fullVaccinationDTOS) {
                if(differentDates.get(i).equals(vac.dateOfFullVaccination)) {
                    amountPerDate.set(i,amountPerDate.get(i)+1);

                }

            }
        }

        String dir = System.getProperty("user.dir");
        PrintWriter pw = new PrintWriter(new File(dir+"/src/main/resources/files/"+localDate.toString()+"_"+localDate2.toString()+".csv"));
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
        System.out.println("Created new file at: "+"/src/main/resources/files/"+localDate+"_"+localDate2+".csv");
    }
}
