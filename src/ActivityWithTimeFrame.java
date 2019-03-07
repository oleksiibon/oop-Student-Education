import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class ActivityWithTimeFrame extends Activity {
    LocalDate endEducationDate;
    LocalDate startEducationDate;

    public ActivityWithTimeFrame(Education education, Visit visit, LocalDate startEducationDate, LocalDate endEducationDate) {
        super(education, visit);
        this.endEducationDate = endEducationDate;
        this.startEducationDate = startEducationDate;
    }
    public ActivityWithTimeFrame(Education education, Visit visit, int startEducationYear, int endEducationYear) {
        super(education, visit);
        this.endEducationDate = LocalDate.of(endEducationYear, 7,1);
        this.startEducationDate = LocalDate.of(startEducationYear, 8, 30);
    }

    @Override
    public void addActivityToSchedule(Map<LocalDate,Day> schedule, LocalDate endDate) {
        Predicate<LocalDate> predicate = visit.getPredicate();
        Set<LocalDate> mapKey = schedule.keySet();
        mapKey.stream()
                .filter(p -> startEducationDate.isBefore(p) && endEducationDate.isAfter(p))
                .filter(predicate)
                .forEach(p -> schedule.get(p).addEducation(education));
    }

}
