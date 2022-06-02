package app.controller.receptionistController;

import app.domain.model.*;


import java.util.List;

public class ReceptionistController {
    Company company;
    public ReceptionistController(Company company){
        this.company = company;
    }

    public List<VacCenter> getVacCenterList(){
        return this.company.getVacCenterList().showAllVacCenters();
    }
    public boolean checkInUser(UserLastVaccineDTO snsUser, VacCenter vacCenter){
        return vacCenter.checkInSnsUser(snsUser);
    }

    public boolean checkOutUser(UserLastVaccineDTO snsUser, VacCenter vacCenter){
        return vacCenter.checkOutSnsUser(snsUser);
    }

    public UserLastVaccineDTO checkIfUserExists(int snsNumber){
        return this.company.createDTO(snsNumber);
    }

    public List<UserLastVaccineDTO> getWaitingLists(VacCenter vacCenter){
        return vacCenter.waitingRoom();
    }
}
