import java.time.LocalDate;
import java.util.function.Predicate;

public class OneDayVisit implements Visit {
    LocalDate currentDate;

    public OneDayVisit(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public Predicate<LocalDate> getPredicate() {
        return p -> p.isEqual(currentDate);
    }
}
