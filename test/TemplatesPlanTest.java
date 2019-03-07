import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TemplatesPlanTest {
    Map<LocalDate, Day> pacifistSchedule = new ScheduleBuilder(LocalDate.of(2026,11,11))
            .university()
            .build();

    Student student = new Student(new Knowledge(10.0,10.0), 0.5, "Lex");

    @Test
    void usePacifistSchedule() {
        student.addSchedule(pacifistSchedule);
        student.usePlan();

        assertThat(student.getKnowledge().theoretical, is(38035.0));
        assertThat(student.getKnowledge().practice, is (15220.0));
    }


}
