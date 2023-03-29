package platforms;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static platforms.EventType.ARRIVAL;
import static platforms.EventType.DEPARTURE;

public class Calculator {
    Map<Integer, EventType> events = new TreeMap<>();
    public int calculatePlatforms(List<TrainSchedule> timetable) {
        var counter = 0;
        var max = 0;

        timetable.forEach(trainSchedule -> {
            var arrivalTime = convertTimeStringtoInteger(trainSchedule.arrival());
            var departureTime = convertTimeStringtoInteger(trainSchedule.departure());
            if (arrivalTime >= departureTime) {
                throw new RuntimeException("Invalid schedule provided: %s"
                        .formatted(trainSchedule));
            }
            events.put(arrivalTime, ARRIVAL);
            events.put(departureTime, DEPARTURE);
        });
        for (var event : events.values()) {
            counter = counter + ((event == ARRIVAL) ? 1 : -1);
            if (counter > max) max = counter;
        }
        return max;
    }

    private static Integer convertTimeStringtoInteger(String entry) {
        return Integer.valueOf(entry.replace(":", ""));
    }
}
