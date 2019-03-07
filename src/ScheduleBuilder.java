import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ScheduleBuilder {
    Plan plan;

    public ScheduleBuilder(LocalDate endPlanDate) {
        this.plan = new Plan(endPlanDate);
    }

    public ScheduleBuilder meetUp() {
        plan.addActivity(new Activity(new MeetUp(new Knowledge(50, 50), "WorkShop"), new OneDayVisit(LocalDate.of(2020, 5, 6))));
        return this;
    }

    public ScheduleBuilder university() {
        plan.addActivity(new ActivityWithTimeFrame(new Organization("ChNU", new Knowledge(10, 50)), new WeekdayVisit(), 2019, 2025));
        return this;
    }

    public ScheduleBuilder selfEducation() {
        plan.addActivity(new Activity(new SelfEducation("Read Book", new Knowledge(1, 8)), new EverydayVisit()));
        return this;
    }

    public ScheduleBuilder meeting() {
        plan.addActivity(new Activity(new Meeting(new Student(new Knowledge(20, 20), 0.5, "Lex")), new OneDayAWeekVisit(DayOfWeek.THURSDAY)));

        return this;
    }

    public ScheduleBuilder internShip() {
        plan.addActivity(new ActivityWithTimeFrame(new Organization("Interlink", new Knowledge(50, 30)), new WeekdayVisit(), LocalDate.of(2023, 3, 1), LocalDate.of(2023, 6, 1)));
        return this;
    }

    public Map<LocalDate, Day> build() {
        return plan.getSchedule();
    }
}
