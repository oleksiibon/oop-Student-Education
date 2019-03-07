import java.time.LocalDate;

public class University implements Education {
    private String name;
    private Knowledge knowledge;

    public University(String name, Knowledge knowledge) {
        this.name = name;
        this.knowledge = knowledge;
    }

    @Override
    public Knowledge getKnowledgeFromEducation() {
            return knowledge;
    }

}
