package app.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


import java.util.List;

public class UserVaccines {
    private List<UserVaccinesDTO> vaccineList;

    public UserVaccines(){
        vaccineList=new ArrayList<>();
    }

    public void addVaccine(UserVaccinesDTO vaccine){
        vaccineList.add(vaccine);
    }

    public List<UserVaccinesDTO> getUserVaccinesDto(){
        return this.vaccineList;
    }

    public Vaccine lastVaccine(){
        if(!this.vaccineList.isEmpty())
            return this.vaccineList.get(this.vaccineList.size()-1).vaccine;
        else
            return null;
    }

    public LocalDateTime lastVaccineDate(){
        if(!this.vaccineList.isEmpty())
            return this.vaccineList.get(this.vaccineList.size()-1).lastDoseDate();
        else
            return null;
    }

}
