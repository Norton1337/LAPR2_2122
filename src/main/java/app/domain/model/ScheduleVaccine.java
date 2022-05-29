package app.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ScheduleVaccine {
    LocalDate dateVaccine;
    LocalTime timeVaccine;
    Map<Integer, String> ScheduleList = new HashMap<>();

    public ScheduleVaccine(LocalDate dateVaccine, LocalTime timeVaccine, Map<Integer, String> scheduleList) {
        this.dateVaccine = dateVaccine;
        this.timeVaccine = timeVaccine;
        ScheduleList = scheduleList;
    }
}
