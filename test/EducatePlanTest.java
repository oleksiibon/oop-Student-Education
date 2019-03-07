import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EducatePlanTest {
    private Student student = new Student(new Knowledge(10, 10), 0.5, "Vova");
    private Plan plan = new Plan(LocalDate.of(2019, 3, 12));
    private Plan planForTwoMonth = new Plan(LocalDate.of(2019, 4, 12));
    private Student Lex_20_20 = new Student(new Knowledge(20, 20), 0.5, "Lex");
    private Map<LocalDate, Day> schedule;
    private OneDayVisit oneDayCondition = new OneDayVisit(LocalDate.of(2019,3,10));
    private OneDayVisit oneDayConditionNotInRange = new OneDayVisit(LocalDate.of(2119,3,10));
    private Meeting meetingWithLex_20_20 = new Meeting(Lex_20_20);
    private WeekdayVisit weekdayVisit = new WeekdayVisit();
    private OneDayAWeekVisit visitOnFriday = new OneDayAWeekVisit(DayOfWeek.FRIDAY);
    private OneDayAMonthVisit visitEveryTenthDayOfMonth = new OneDayAMonthVisit(10);
    private MeetUp meetUp_50_50 = new MeetUp(new Knowledge(50, 50), "WorkShop");

    @BeforeEach
    void setUp() {

    }

    @Test
    void goToMeetUp__whenMeetUpWillBeOnce() {
//        List <Education> educationList = new ArrayList<>();
//        educationList.add(new Education(new Knowledge(50,50)));
//        schedule.add(new Day(educationList));
        plan.addActivity(new Activity(meetUp_50_50, oneDayCondition));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(35.0));
    }

    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeAlways() {
        plan.addActivity(new Activity(meetingWithLex_20_20, new EverydayVisit()));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(70.0));
    }

    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeOnce() {
        plan.addActivity(new Activity(meetingWithLex_20_20, oneDayCondition));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(20.0));
    }
    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeOnce__andNotInRangePlan() {
        plan.addActivity(new Activity(meetingWithLex_20_20, oneDayConditionNotInRange));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(10.0));
    }
    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeEveryWeekDay() {
        plan.addActivity(new Activity(meetingWithLex_20_20, weekdayVisit));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(50.0));
    }
    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeOneDayInWeek() {
        plan.addActivity(new Activity(meetingWithLex_20_20, visitOnFriday));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(20.0));
    }

    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeOneDayInMonth() {
        planForTwoMonth.addActivity(new Activity(meetingWithLex_20_20, visitEveryTenthDayOfMonth));
        schedule = planForTwoMonth.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(30.0));
    }

    @Test
    void selfEducationEveryDay() {
        plan.addActivity(new Activity(new SelfEducation("Read Book", new Knowledge(1,8)), new EverydayVisit()));
        schedule = plan.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();
        assertThat(knowledge.practice, is(13.0));
    }

    @Test
    void goToMeetingWithOtherStudent__whenThisMeetingWillBeOneDayInMonth__goToOneMeetUp() {
        planForTwoMonth.addActivity(new Activity(meetingWithLex_20_20, visitEveryTenthDayOfMonth));
        planForTwoMonth.addActivity(new Activity(meetUp_50_50, oneDayCondition));
        schedule = planForTwoMonth.getSchedule();
        student.addSchedule(schedule);
        student.usePlan();
        Knowledge knowledge = student.getKnowledge();

        assertThat(knowledge.practice, is(55.0));
    }
}
