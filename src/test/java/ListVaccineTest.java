import app.controller.vaccineController.VaccineController;
import app.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListVaccineTest {
    VaccineController vaccineController = new VaccineController(new Company());
    AgeGroup ageGroup1 = new AgeGroup(10,18,new TimeInterval(50));
    AgeGroup ageGroup2 = new AgeGroup(19,25,new TimeInterval(60));
    AgeGroup ageGroup3 = new AgeGroup(26,50,new TimeInterval(30));
    List<AgeGroup> ageGroups = new ArrayList<>();
    VaccinationProcess vaccinationProcess;
    VaccineType vaccineType;
    VaccineType vaccineType2;
    VaccineType vaccineType3;
    VaccineType vaccineType4;
    VaccineType vaccineType5;
    VaccineType vaccineType6;

    @BeforeEach
    public void setUp() {
        ageGroups.add(ageGroup1);
        ageGroups.add(ageGroup2);
        ageGroups.add(ageGroup3);
        vaccinationProcess = new VaccinationProcess(30, ageGroups);
        vaccineType = new VaccineType("covid");
        vaccineType2 = new VaccineType("beta");
        vaccineType3 = new VaccineType("delta");
        vaccineType4 = new VaccineType("delta");
        vaccineType5 = new VaccineType("delta");
        vaccineType6 = new VaccineType("delta");
        vaccineController.createVaccine("alpha",123456,vaccineType,vaccinationProcess);
        vaccineController.createVaccine("test",123456,vaccineType2,vaccinationProcess);
        vaccineController.createVaccine("charlie",123456,vaccineType3,vaccinationProcess);
        vaccineController.createVaccine("alpha",123456,vaccineType4,vaccinationProcess);
        vaccineController.createVaccine("betaName",123456,vaccineType5,vaccinationProcess);
        vaccineController.createVaccine("zeta",123456,vaccineType6,vaccinationProcess);
    }

    @Test
    public void test(){
        for (Vaccine vaccine: vaccineController.getVaccineListOrdered()) {

            System.out.println("Name: "+vaccine.getName()+" - Type: "+vaccine.getVaccineType().getDisease());
        }

    }

}
