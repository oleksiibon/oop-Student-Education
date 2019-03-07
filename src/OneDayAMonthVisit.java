import java.time.LocalDate;
import java.util.function.Predicate;

public class OneDayAMonthVisit implements Visit {
    private int monthDay;

    public OneDayAMonthVisit(int monthDay) {
        this.monthDay = monthDay;
    }

    @Override
    public Predicate<LocalDate> getPredicate() {
        return p -> p.getDayOfMonth() == monthDay;
    }
}
