package app.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    SnsUser snsUser;
    VacCenter vacCenter;
    VaccineType vaccineType;
    LocalDate dateVaccine;
    LocalTime timeVaccine;


    public Appointment(SnsUser snsUserList, VacCenter vacCenterList, VaccineType vaccineTypeList, LocalDate dateVaccine, LocalTime timeVaccine) {
        this.snsUser = snsUserList;
        this.vacCenter = vacCenterList;
        this.vaccineType = vaccineTypeList;
        this.dateVaccine = dateVaccine;
        this.timeVaccine = timeVaccine;
    }

    public SnsUser getSnsUser() {
        return snsUser;
    }

    public void setSnsUser(SnsUser snsUser) {
        this.snsUser = snsUser;
    }

    public VacCenter getVacCenter() {
        return vacCenter;
    }

    public void setVacCenter(VacCenter vacCenter) {
        this.vacCenter = vacCenter;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    public LocalDate getDateVaccine() {
        return dateVaccine;
    }

    public void setDateVaccine(LocalDate dateVaccine) {
        this.dateVaccine = dateVaccine;
    }

    public LocalTime getTimeVaccine() {
        return timeVaccine;
    }

    public void setTimeVaccine(LocalTime timeVaccine) {
        this.timeVaccine = timeVaccine;
    }
}
