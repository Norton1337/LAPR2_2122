import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.domain.model.AgeGroup;
import app.domain.model.TimeInterval;
import app.domain.model.VaccinationProcess;
import app.domain.model.Vaccine;
import app.domain.model.VaccineType;

public class VaccineTests {
    AgeGroup ageGroup1 = new AgeGroup(10,18,new TimeInterval(50));
    AgeGroup ageGroup2 = new AgeGroup(19,25,new TimeInterval(60));
    AgeGroup ageGroup3 = new AgeGroup(26,50,new TimeInterval(30));
    List<AgeGroup> ageGroups = new ArrayList<>();
    VaccinationProcess vaccinationProcess;
    VaccineType vaccineType;
    Vaccine vaccine;
    @BeforeEach
    public void setUp() {
        ageGroups.add(ageGroup1);
        ageGroups.add(ageGroup2);
        ageGroups.add(ageGroup3);
        vaccinationProcess = new VaccinationProcess(30, ageGroups);
        vaccineType = new VaccineType("covid");
        vaccine = new Vaccine("name",123456,vaccineType,vaccinationProcess);
    }

    @Test
    public void vaccineNameTest(){
        assertEquals("name",vaccine.getName());
    }
    @Test
    public void vaccineLotNumTest(){
        assertEquals(123456,vaccine.getLotNUmber());
    }
    @Test
    public void vaccineVaxProcessTest(){
        assertEquals(vaccinationProcess,vaccine.getVaccinationProcess());
    }
    @Test
    public void vaccineTypeTest(){
        assertEquals(vaccineType,vaccine.getVaccineType());
    }
}
