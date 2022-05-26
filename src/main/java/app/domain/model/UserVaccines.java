package app.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


import java.util.List;

public class UserVaccines {
    private List<LocalDateTime> vaccineDateList;
    private List<Vaccine> vaccineList;

    public UserVaccines(){
        vaccineDateList=new ArrayList<>();
        vaccineList=new ArrayList<>();
    }

    public void addVaccine(Vaccine vaccine){
        LocalDateTime newDate = LocalDateTime.now();
        System.out.println(newDate);
        vaccineList.add(vaccine);
        vaccineDateList.add(newDate);
    }

    public Vaccine lastVaccine(){
        if(!this.vaccineList.isEmpty())
            return this.vaccineList.get(this.vaccineList.size()-1);
        else
            return null;
    }

    public LocalDateTime lastVaccineDate(){
        if(!this.vaccineDateList.isEmpty())
            return this.vaccineDateList.get(this.vaccineDateList.size()-1);
        else
            return null;
    }

}
