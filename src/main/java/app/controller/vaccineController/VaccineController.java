package app.controller.vaccineController;

import app.domain.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VaccineController {
    private final Company company;

    public VaccineController(Company company) {
        this.company = company;
    }


    public VaccineType registerVaccineType(String disease) {
        return company.createVaccineType(disease);
    }

    public List<VaccineType> listVaccineTypes() {
        return company.listVaccineTypes();
    }


    public Vaccine createVaccine(String name, int lotnumber, VaccineType vaccineType, VaccinationProcess vaccinationProcess) {
        return company.createVaccine(name, lotnumber, vaccineType, vaccinationProcess);

    }


    public List<Vaccine> listVaccine() {
        return company.listVaccine();
    }


    public VaccinationProcess createVaccinationProcess(int recoveryPeriod, List<AgeGroup> ageGroupList) {
        return null;
    }

    public AgeGroup createAgeGroup(int minAge, int maxAge, int numDaysInterval) {
        return company.createAgeGroup(minAge, maxAge, numDaysInterval);
    }

    public List<Vaccine> getVaccineListOrdered() {
        List<Vaccine> vaccineList;
        vaccineList = listVaccine();
        if (vaccineList.size() > 0) {
            Collections.sort(vaccineList);
        }
        return vaccineList;
    }

    public List<Vaccine> getVaccineListOrderedByType(List<Vaccine> vaccineList) {
        for(int i=0; i<vaccineList.size();i++){
            for (int j=i+1; j<vaccineList.size();j++){
                String typeA = vaccineList.get(i).getVaccineType().getDisease();
                String typeB= vaccineList.get(j).getVaccineType().getDisease();
                if(typeA.compareTo(typeB)>0){
                    String temp = typeA;
                    typeA = typeB;
                    typeB = temp;
                }
            }
        }
        return vaccineList;
    }

    public void printList(List<Vaccine> vaccineList2) {
        for (int i=0 ; i<vaccineList2.size();i++)
        {
            System.out.println(vaccineList2.get(i).getName() + vaccineList2.get(i).getVaccineType());
        }
    }
}
