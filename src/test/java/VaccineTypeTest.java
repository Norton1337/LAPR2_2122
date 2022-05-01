import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import app.domain.model.VaccineType;

public class VaccineTypeTest {
    
    @Test
    public void vaccineTypeTest(){
        VaccineType type = new VaccineType("covid");
        assertEquals("covid", type.getDisease());
    }
}
