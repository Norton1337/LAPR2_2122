package app.controller.vaccineController;

import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class VaccineController {
    private final Company company;
    public VaccineController(){
        this.company = new Company();
    }

    public VaccineType registerVaccineType(String disease) {
        return company.createVaccineType(disease);
    }

    public List<VaccineType> listVaccineTypes() {
        return company.listVaccineTypes();
    }




    public Vaccine createVaccine(String name, int lotnumber, VaccineType vaccineType, VaccinationProcess vaccinationProcess){
       return company.createVaccine(name,lotnumber,vaccineType,vaccinationProcess);

    }


    public List<Vaccine> listVaccine() {
        return company.listVaccine();
    }




    public VaccinationProcess createVaccinationProcess(int recoveryPeriod, List<AgeGroup> ageGroupList){
        return null;
    }

    public AgeGroup createAgeGroup(int minAge, int maxAge, int numDaysInterval){
        return company.createAgeGroup(minAge,maxAge,numDaysInterval);
    }

}
