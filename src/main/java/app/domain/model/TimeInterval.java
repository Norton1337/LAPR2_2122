package app.domain.model;

public class TimeInterval {
    private int numDays;

    public TimeInterval(int numDays){
        this.numDays=numDays;
    }

    public int getNumDays() {
        return this.numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

}
