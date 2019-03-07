public class SelfEducation implements Education {
    private String name;
    private Knowledge knowledge;

    public SelfEducation(String name, Knowledge knowledge) {
        this.name = name;
        this.knowledge = knowledge;
    }

    @Override
    public Knowledge getKnowledgeFromEducation() {
        return knowledge;
    }
}
