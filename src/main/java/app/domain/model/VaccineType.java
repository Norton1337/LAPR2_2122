package app.domain.model;

public class VaccineType {

    private String disease;

    public VaccineType(String disease) {
        this.disease=disease;
    }

    public String getDisease(){
        return this.disease;
    }
    public void setDisease(String disease){
        this.disease=disease;
    }

    @Override
    public String toString() {
        return "VaccineType{" +
                "disease=" + disease +
                '}';
    }


}
