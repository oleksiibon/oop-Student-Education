import java.time.LocalDate;
import java.util.Map;

public class Student {
    Knowledge knowledge;
    double learnability;
    Map<LocalDate, Day> schedule;
    String name;

    public Student(Knowledge knowledge, double learnability, String name) {
        this.knowledge = knowledge;
        this.learnability = learnability;
        this.name = name;
    }

    public void addSchedule(Map <LocalDate, Day> schedule){
        this.schedule = schedule;
    }

    public void usePlan() {
        for (Day day : schedule.values()) {
            for (Education education: day.getEducationList()) {
                addKnowledge(education.getKnowledgeFromEducation());
            }
        }
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }


    public void addKnowledge(Knowledge knowledge) {
        this.knowledge.practice += knowledge.practice*learnability;
        this.knowledge.theoretical += knowledge.theoretical*learnability;
    }
}
