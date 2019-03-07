import java.time.LocalDate;
import java.util.function.Predicate;

public class EverydayVisit implements Visit {

    @Override
    public Predicate<LocalDate> getPredicate() {
        return p -> true;
    }
}
