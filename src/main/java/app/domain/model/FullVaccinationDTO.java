package app.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FullVaccinationDTO {
    public int snsNumber;
    public LocalDate dateOfFullVaccination;

    public FullVaccinationDTO(int snsNumber, LocalDate dateOfFullVaccination){
        this.snsNumber=snsNumber;
        this.dateOfFullVaccination=dateOfFullVaccination;
    }
}
