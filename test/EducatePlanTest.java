import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EducatePlanTest {
    Student student = new Student(new Knowledge(10, 10), 0.5, "Vova");
    Plan plan = new Plan(LocalDate.of(2019, 3, 12));
    Student Lex_20_20 = new Student(new Knowledge(20, 20), 0.5, "Lex");
    Map<LocalDate, Day> schedule;
    OneDayVisit oneDayCondition = new OneDayVisit(LocalDate.of(2019,3,10));
    OneDayVisit oneDayConditionNotInRange = new OneDayVisit(LocalDate.of(2119,3,10));
    Meeting meetingWithLex_20_20 = new Meeting(Lex_20_20);
    WeekdayVisit weekdayVisit = new WeekdayVisit();
    OneDayAWeekVisit visitOnFriday = new OneDayAWeekVisit(DayOfWeek.FRIDAY);

    @BeforeEach
    void setUp() {

    }

    @Test
    void goToMeetUp__whenMeetUpWillBeOnce() {
//        List <Education> educationList = new ArrayList<>();
//        educationList.add(new Education(new Knowledge(50,50)));
//        schedule.add(new Day(educationList));
        plan.addActivity(new Activity(new MeetUp(new Knowledge(50, 50)), oneDayCondition));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(35));
    }

    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeAlways() {
        plan.addActivity(new Activity(meetingWithLex_20_20, new EverydayVisit()));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(70));
    }

    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeOnce() {
        plan.addActivity(new Activity(meetingWithLex_20_20, oneDayCondition));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(20));
    }
    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeOnce__andNotInRangePlan() {
        plan.addActivity(new Activity(meetingWithLex_20_20, oneDayConditionNotInRange));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(10));
    }
    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeEveryWeekDay() {
        plan.addActivity(new Activity(meetingWithLex_20_20, weekdayVisit));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(50));
    }
    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeOneDayInWeekDay() {
        plan.addActivity(new Activity(meetingWithLex_20_20, visitOnFriday));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(20));
    }
}
