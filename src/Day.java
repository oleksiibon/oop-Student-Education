import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Day {
    private List<Education> educationList = new ArrayList<>();

    public List<Education> getEducationList() {
        return educationList;
    }

    public void addEducation(Education education) {
        educationList.add(education);
    }
}
