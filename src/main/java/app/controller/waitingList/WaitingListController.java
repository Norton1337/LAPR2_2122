package app.controller.waitingList;

import app.domain.model.*;

import java.util.List;

public class WaitingListController {

    private final Company company;


    public WaitingListController( Company company) {
        this.company = company;

    }


    public List<UserLastVaccineDTO> getVacCenterWaitingList(VacCenter vacCenter){
        return vacCenter.waitingRoom();
    }


}
