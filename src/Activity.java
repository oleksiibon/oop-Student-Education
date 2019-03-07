import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class Activity {
    Education education;
    Visit visit;

    public Activity(Education education, Visit condition) {
        this.education = education;
        this.visit = condition;
    }

    public void addActivityToSchedule(Map<LocalDate,Day> schedule,  LocalDate endDate) {
        Predicate<LocalDate> predicate = visit.getPredicate();
        Set<LocalDate> mapKey = schedule.keySet();
        mapKey.stream()
                .filter(predicate)
                .forEach(p -> schedule.get(p).addEducation(education));
    }
}
