package app.domain.model;

import java.util.List;

public class VaccinationProcess {
    private int recoveryPeriod;
    private List<AgeGroup> ageGroupList;

    public VaccinationProcess(int recoveryPeriod, List<AgeGroup> ageGroups){
        this.recoveryPeriod=recoveryPeriod;
        this.ageGroupList=ageGroups;

    }

    public int getRecoveryPeriod() {
        return this.recoveryPeriod;
    }

    public void setRecoveryPeriod(int recoveryPeriod) {
        this.recoveryPeriod = recoveryPeriod;
    }

    public List<AgeGroup> getAgeGroupList() {
        return this.ageGroupList;
    }

    public void setAgeGroupList(List<AgeGroup> ageGroupList) {
        this.ageGroupList = ageGroupList;
    }

}
