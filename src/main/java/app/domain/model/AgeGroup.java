package app.domain.model;

import java.util.List;

public class AgeGroup {
    private int minAge;
    private int maxAge;
    private List<Dose> doseList;
    private TimeInterval timeInterval;

    public AgeGroup(int minAge, int maxAge, TimeInterval timeInterval){
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.timeInterval=timeInterval;
    }

    public int getMinAge() {
        return this.minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public List<Dose> getDoseList() {
        return this.doseList;
    }

    public void setDoseList(List<Dose> doseList) {
        this.doseList = doseList;
    }

    public TimeInterval getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

}
