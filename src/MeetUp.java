public class MeetUp implements Education{
    Knowledge knowledge;
    String name;

    public MeetUp(Knowledge knowledge, String name) {
        this.knowledge = knowledge;
        this.name = name;
    }

    public Knowledge getKnowledgeFromEducation() {
        return knowledge;
    }
}
