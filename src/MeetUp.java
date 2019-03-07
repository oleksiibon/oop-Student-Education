public class MeetUp implements Education{
    Knowledge knowledge;
    public MeetUp(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public Knowledge getKnowledgeFromEducation() {
        return knowledge;
    }
}
