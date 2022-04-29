package app.domain.model;

public class Dose {
    private int doseNumber;
    private int dosage;

    public Dose(int doseNumber, int dosage){
        this.doseNumber=doseNumber;
        this.dosage=dosage;
    }

    public int getDoseNumber() {
        return this.doseNumber;
    }

    public void setDoseNumber(int doseNumber) {
        this.doseNumber = doseNumber;
    }

    public int getDosage() {
        return this.dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

}
