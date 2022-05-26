package app.domain.model;


import java.time.LocalDateTime;

public class UserLastVaccineDTO {
    private int snsNumber;
    private String name;
    private int age;
    private LocalDateTime lastVaccineDate;
    private Vaccine lastVaccine;

    public UserLastVaccineDTO(int snsNumber, String name, int age, LocalDateTime lastVaccineDate, Vaccine lastVaccine){
            this.snsNumber=snsNumber;
            this.name=name;
            this.age=age;
            this.lastVaccine = lastVaccine;
            this.lastVaccineDate = lastVaccineDate;
    }

    public int getSnsNumber() {
        return snsNumber;
    }

    public void setSnsNumber(int snsNumber) {
        this.snsNumber = snsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getLastVaccineDate() {
        return lastVaccineDate;
    }

    public void setLastVaccineDate(LocalDateTime lastVaccineDate) {
        this.lastVaccineDate = lastVaccineDate;
    }

    public Vaccine getLastVaccine() {
        return lastVaccine;
    }

    public void setLastVaccine(Vaccine lastVaccine) {
        this.lastVaccine = lastVaccine;
    }
}
