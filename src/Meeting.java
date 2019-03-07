public class Meeting implements Education {
    Knowledge knowledge;

    public Meeting(Student student) {
        this.knowledge = student.getKnowledge();
    }

    @Override
    public Knowledge getKnowledgeFromEducation() {
        return knowledge;
    }
}
