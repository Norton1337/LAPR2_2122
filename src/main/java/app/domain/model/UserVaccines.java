package app.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserVaccines {
    private List<LocalDate> vaccineDateList;
    private List<Vaccine> vaccineList;

    public UserVaccines(){
        vaccineDateList=new ArrayList<>();
        vaccineList=new ArrayList<>();
    }

    public void addVaccine(Vaccine vaccine){
        LocalDate newDate = LocalDate.now();
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

    public LocalDate lastVaccineDate(){
        if(!this.vaccineDateList.isEmpty())
            return this.vaccineDateList.get(this.vaccineDateList.size()-1);
        else
            return null;
    }

}
