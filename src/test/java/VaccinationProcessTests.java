import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import app.domain.model.AgeGroup;
import app.domain.model.TimeInterval;
import app.domain.model.VaccinationProcess;

public class VaccinationProcessTests {

    AgeGroup ageGroup1 = new AgeGroup(10,18,new TimeInterval(50));
    AgeGroup ageGroup2 = new AgeGroup(19,25,new TimeInterval(60));
    AgeGroup ageGroup3 = new AgeGroup(26,50,new TimeInterval(30));
    List<AgeGroup> ageGroups = new ArrayList<>();
    VaccinationProcess vaccinationProcess;
    @BeforeEach
    public void setUp() {
        ageGroups.add(ageGroup1);
        ageGroups.add(ageGroup2);
        ageGroups.add(ageGroup3);
        vaccinationProcess = new VaccinationProcess(30, ageGroups);
    }

    @Test
    public void recoveryPeriodTest(){
        assertEquals(30,vaccinationProcess.getRecoveryPeriod());
    }

    @Test
    public void AgeGroupsTest(){
        assertEquals(3,vaccinationProcess.getAgeGroupList().size());
    }
}
