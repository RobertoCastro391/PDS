public class Director extends Monitor {
    private Course degreeName;

    public Director (StudentAdm stud, Course degree) {
        
        super(stud);
        this.degreeName = degree;
        
        if (degree != stud.getStudent().getCourse()) {
            System.err.println("Error: Director´s coure must be the same as student´s course");
        }
    
        adm.attachDirector(this);
        // ...
    }

    public Course getCourseName() {
        return degreeName;
    }

    public void update(Student student, String className) {
        System.out.printf("%s director reports that student %s (%d) has changed the overall grade: %.1f\n", getCourseName(), student.getName(), student.getId(), student.getOverallGrade());
    }
}