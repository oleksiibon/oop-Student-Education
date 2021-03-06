import java.time.LocalDate;

public class Organization implements Education {
    private String name;
    private Knowledge knowledge;

    public Organization(String name, Knowledge knowledge) {
        this.name = name;
        this.knowledge = knowledge;
    }

    @Override
    public Knowledge getKnowledgeFromEducation() {
        return knowledge;
    }

}
