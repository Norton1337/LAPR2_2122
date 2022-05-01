import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import app.domain.model.Dose;

public class DoseTests {
    

    @Test
    public void doseNumberTest(){
        Dose dose = new Dose(10,5);
        assertEquals(10,dose.getDoseNumber());
    }
    @Test
    public void dosageTest(){
        Dose dose = new Dose(10,5);
        assertEquals(5,dose.getDosage());
    }
}
