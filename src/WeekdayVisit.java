import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Predicate;

public class WeekdayVisit implements Visit {

    public Predicate<LocalDate> getPredicate() {
        return p -> p.getDayOfWeek() != DayOfWeek.SUNDAY && p.getDayOfWeek() != DayOfWeek.SATURDAY;
    }
}
