import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import app.domain.model.TimeInterval;

public class TimeIntervalTest {

    @Test
    public void testNumDays(){
        TimeInterval interval = new TimeInterval(5);
        assertEquals(5, interval.getNumDays());
    } 
    
}
