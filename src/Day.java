import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Day {
    private List<Education> educationList = new ArrayList<>();
    private LocalDate date;

    public Day(LocalDate date) {
        this.date = date;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void addEducation(Education education) {
        educationList.add(education);
    }

    public LocalDate getDate() {
        return date;
    }
}
