public class Professor extends Monitor {
    private String className;
    private String name;

    public Professor(StudentAdm adm, String name, String className) {
        super(adm);
        this.name = name;
        this.className = className;
        adm.attachProfessor(this);
        // ...
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public void update(Student student, String className, double score) {
        System.out.printf("Professor %s of %s class evaluated student %s (%d) with score: %.1f\n", getName(), className, student.getName(), student.getId(), score);
    }
}