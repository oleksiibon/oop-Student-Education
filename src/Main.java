import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<LocalDate, Day> pacifistSchedule = new ScheduleBuilder(LocalDate.of(2026, 11, 11))
                .university()
                .build();

        Map<LocalDate, Day> selfTaughtSchedule = new ScheduleBuilder(LocalDate.of(2026, 11, 11))
                .meetUp()
                .internShip()
                .selfEducation()
                .build();

        Map<LocalDate, Day> teachMeSchedule = new ScheduleBuilder(LocalDate.of(2026, 11, 11))
                .university()
                .meetUp()
                .meetUp()
                .meetUp()
                .build();

        Map<LocalDate, Day> consciousSchedule = new ScheduleBuilder(LocalDate.of(2026, 11, 11))
                .university()
                .meetUp()
                .meeting()
                .meetUp()
                .selfEducation()
                .internShip()
                .build();

        Student student1 = new Student(new Knowledge(10.0, 10.0), 0.5, "Lex");
        Student student2 = new Student(new Knowledge(10.0, 10.0), 0.5, "Lex");
        Student student3 = new Student(new Knowledge(10.0, 10.0), 0.5, "Lex");
        Student student4 = new Student(new Knowledge(10.0, 10.0), 0.5, "Lex");

        student1.addSchedule(pacifistSchedule);
        student1.usePlan();

        student2.addSchedule(selfTaughtSchedule);
        student2.usePlan();

        student3.addSchedule(teachMeSchedule);
        student3.usePlan();

        student4.addSchedule(consciousSchedule);
        student4.usePlan();

        System.out.println("Pacifist get practice and theoretical points: " + student1.getKnowledge().practice + " " + student1.getKnowledge().theoretical);
        System.out.println("Self-taught get practice and theoretical points: " + student2.getKnowledge().practice + " " + student2.getKnowledge().theoretical);
        System.out.println("Teach me - student get practice and theoretical points: " + student3.getKnowledge().practice + " " + student3.getKnowledge().theoretical);
        System.out.println("Conscious student get practice and theoretical points: " + student4.getKnowledge().practice + " " + student4.getKnowledge().theoretical);
    }
}
