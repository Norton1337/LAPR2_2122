import app.domain.model.VacCenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VacCenterTest {
    VacCenter vacCenter = new VacCenter(
            "Vacinação Porto",
            "Rua do Porto",
            "912626999",
            "019283746",
            "website@test.com",
            9,
            19,
            12,
            200);

    @Test
    public void testGetters() {
        assertEquals("Vacinação Porto", vacCenter.getName());
        assertEquals("Rua do Porto", vacCenter.getAddress());
        assertEquals("912626999", vacCenter.getPhoneNumber());
        assertEquals("019283746", vacCenter.getFaxNumber());
        assertEquals("website@test.com", vacCenter.getWebsite());
        assertEquals(9, vacCenter.getOpeningHour());
        assertEquals(19, vacCenter.getClosingHour());
        assertEquals(12, vacCenter.getSlotDuration());
        assertEquals(200, vacCenter.getMaxVaccines());
    }
}