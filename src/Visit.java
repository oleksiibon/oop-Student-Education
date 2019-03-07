import java.time.LocalDate;
import java.util.function.Predicate;

public interface Visit {

    Predicate<LocalDate> getPredicate();
}
