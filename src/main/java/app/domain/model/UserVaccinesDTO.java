package app.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserVaccinesDTO {
    public Vaccine vaccine;
    public int currentDose;
    public List<LocalDateTime> doseDateTime;
    private int maxDose;


    public UserVaccinesDTO(Vaccine vaccine, int userAge){
        this.vaccine = vaccine;
        List<AgeGroup> ageGroups = vaccine.getVaccinationProcess().getAgeGroupList();
        this.maxDose=0;
        this.doseDateTime=new ArrayList<>();
        for (AgeGroup ageGroup: ageGroups) {
            if(ageGroup.getMinAge() < userAge && ageGroup.getMaxAge() > userAge){
                this.maxDose = ageGroup.getDose().getDoseNumber();
            }
        }
        if(this.maxDose!=0 ){
            this.currentDose=1;
            doseDateTime.add(LocalDateTime.now());
        }

    }

    public boolean newDose(){
        if(currentDose+1>maxDose){
            return false;
        }

        this.currentDose++;
        doseDateTime.add(LocalDateTime.now());
        return true;

    }

    public LocalDateTime lastDoseDate(){
        int size=doseDateTime.size();
        return doseDateTime.get(size-1);
    }

    public boolean endedVaccination(){
        return this.currentDose==maxDose;
    }

}
