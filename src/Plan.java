import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plan {
    Map<LocalDate, Day> schedule = new HashMap<>();
    List <Activity> activities = new ArrayList<>();
    private LocalDate todayDate = LocalDate.of(2019,3,7);
    private LocalDate endDate;

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public Plan(LocalDate endDate) {
        this.endDate = endDate;
        LocalDate currentDate = todayDate;
        while (endDate.isAfter(currentDate) || endDate.isEqual(currentDate)) {
            schedule.put(currentDate, new Day(currentDate));
            currentDate = currentDate.plusDays(1);
        }
    }

    public Map<LocalDate, Day> getSchedule() {
        for (Activity activity : activities) {
            activity.addActivityToSchedule(schedule, endDate);
        }
        return schedule;
    }

}
