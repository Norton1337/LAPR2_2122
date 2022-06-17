package app.ui.gui;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class FullyVaccinated {

    private SimpleStringProperty snsNumber;
    private LocalDate dateOfFullVaccination;

    public FullyVaccinated(String snsNumber, LocalDate dateOfFullVaccination){
        this.snsNumber=new SimpleStringProperty(snsNumber);
        this.dateOfFullVaccination=dateOfFullVaccination;
    }

    public SimpleStringProperty snsNumberProperty() {
        return snsNumber;
    }

    public void setSnsNumber(String snsNumber) {
        this.snsNumber.set(snsNumber);
    }

    public LocalDate getDateOfFullVaccination() {
        return dateOfFullVaccination;
    }

    public void setDateOfFullVaccination(LocalDate dateOfFullVaccination) {
        this.dateOfFullVaccination = dateOfFullVaccination;
    }

}
