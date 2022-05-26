package app.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WaitingRoom {
    private final List<UserLastVaccineDTO> latestEntries; //Users that entered the waiting room today
    private final List<UserLastVaccineDTO> snsUserList; //Users currently on waiting room
    private final List<LocalDateTime> dateTimeOfArrival;//Arraival time of said users

    public WaitingRoom(){
        this.latestEntries=new ArrayList<>();
        this.snsUserList=new ArrayList<>();
        this.dateTimeOfArrival=new ArrayList<>();
    }

    public boolean checkInSnsUser(UserLastVaccineDTO snsUser){

        if(snsUserList.contains(snsUser))
            return false;
        else{
            Vaccine lastUserVaccine = snsUser.getLastVaccine();
            LocalDateTime date = snsUser.getLastVaccineDate();
            if(lastUserVaccine!=null){
                int userAge = snsUser.getAge();
                AgeGroup ageGroup = lastUserVaccine.getVaccinationProcess().getBelongingAgeGroup(userAge);
                LocalDateTime nextPossibleDate = date.plusDays(ageGroup.getTimeInterval().getNumDays());
                if(nextPossibleDate.isBefore(LocalDateTime.now()) && !visitedToday(snsUser)) {
                    latestEntries.add(snsUser);
                    dateTimeOfArrival.add(LocalDateTime.now());
                    return snsUserList.add(snsUser);
                }else return false;

            }else {
                if(visitedToday(snsUser))
                    return false;
                else {
                    latestEntries.add(snsUser);
                    dateTimeOfArrival.add(LocalDateTime.now());
                    return snsUserList.add(snsUser);
                }
            }
        }
    }

    private boolean visitedToday(UserLastVaccineDTO snsUser){
        return latestEntries.contains(snsUser);
    }

    public boolean checkOutSnsUser(UserLastVaccineDTO snsUser){
        if(!snsUserList.contains(snsUser))
            return false;
        else{
            dateTimeOfArrival.remove(snsUserList.indexOf(snsUser));
            return snsUserList.remove(snsUser);
        }
    }

}
