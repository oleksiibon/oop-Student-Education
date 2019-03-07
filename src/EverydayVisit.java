import java.time.LocalDate;
import java.util.Map;

public class EverydayVisit implements Visit {

    @Override
    public void addEducation(Education education, Map<LocalDate, Day> schedule, LocalDate endDate) {
        for (Day day : schedule.values()) {
            day.addEducation(education);
        }
    }
}
