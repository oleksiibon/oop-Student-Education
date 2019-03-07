import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Predicate;

public class OneDayAWeekVisit implements Visit {
    DayOfWeek day;


    public OneDayAWeekVisit(DayOfWeek day) {
        this.day = day;
    }

    public Predicate<LocalDate> getPredicate() {
        return p -> p.getDayOfWeek() == day;
    }
}
