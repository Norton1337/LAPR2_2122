import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import app.domain.model.AgeGroup;
import app.domain.model.TimeInterval;

public class AgeGroupTests {
    TimeInterval timeInterval = new TimeInterval(30);
    AgeGroup age = new AgeGroup(10,18,timeInterval);

    @Test
    public void minAgeTest(){
        assertEquals(10,age.getMinAge());
    }
    @Test
    public void maxAgeTest(){
        assertEquals(18,age.getMaxAge());
    }
    @Test
    public void timeIntervalTest(){
        assertEquals(timeInterval,age.getTimeInterval());
    }
    
}
