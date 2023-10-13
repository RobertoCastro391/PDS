import java.util.ArrayList;

public class StudentAdm {
    private Student student;
    ArrayList<Director> directorsList = new ArrayList<>();
    ArrayList<Professor> professorsList = new ArrayList<>();
    ArrayList<String> subject = new ArrayList<>();

    public StudentAdm(Student s) {
        this.student = s;
    }

    public void addScore(String className, double score) {
        student.addScore(className, (Double) score);
        notifyObservers(className, score);
        // ...
    }
    public Student getStudent() {
        return student;
    }

    public void attachProfessor(Professor p) {
        this.professorsList.add(p);
        this.subject.add(p.getClassName());
    }

    public void attachDirector(Director d) {
        this.directorsList.add(d);
    }

    public void notifyObservers(String className, double score){
        
        Professor p1 = null;
        

        for (Director d : directorsList) {
            d.update(student, className);
        }

        for (Professor p : professorsList) {
            if (p.getClassName() == className){
                p1 = p; 
                p.update(student, className, score);
            }
        }

        for(String className2 : subject){
            for (Professor p : professorsList) {
                if (p.getClassName().equals(className2)) {
                    if (this.student.getScore(className2) != null && p1 != p) {
                        
                        System.out.printf("Professor %s of %s class evaluated student %s (%d) with score: %.1f\n", p.getName(), p.getClassName(), this.student.getName(), this.student.getId(), this.student.getScore(className2));  
                    }
                }
            }
        }
    }
}