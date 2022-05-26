package app.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WaitingRoom {
    private final List<SnsUser> latestEntries = new ArrayList<>(); //Users that entered the waiting room today
    private final List<SnsUser> snsUserList = new ArrayList<>(); //Users currently on waiting room

    public boolean checkInSnsUser(SnsUser snsUser){

        if(snsUserList.contains(snsUser))
            return false;
        else{
            Vaccine lastUserVaccine = snsUser.getUserVaccines().lastVaccine();
            LocalDate date = snsUser.getUserVaccines().lastVaccineDate();
            if(lastUserVaccine!=null){
                int userAge = snsUser.getAge();
                AgeGroup ageGroup = lastUserVaccine.getVaccinationProcess().getBelongingAgeGroup(userAge);
                LocalDate nextPossibleDate = date.plusDays(ageGroup.getTimeInterval().getNumDays());
                if(nextPossibleDate.isBefore(LocalDate.now()) && !visitedToday(snsUser)) {
                    latestEntries.add(snsUser);
                    return snsUserList.add(snsUser);
                }else return false;

            }else {
                if(visitedToday(snsUser))
                    return false;
                else {
                    latestEntries.add(snsUser);
                    return snsUserList.add(snsUser);
                }
            }
        }
    }

    private boolean visitedToday(SnsUser snsUser){
        return latestEntries.contains(snsUser);
    }

    public boolean checkOutSnsUser(SnsUser snsUser){
        if(!snsUserList.contains(snsUser))
            return false;
        else{
            return snsUserList.remove(snsUser);
        }
    }

}
