import java.util.ArrayList;

public abstract class Monitor {
        protected StudentAdm adm;
        ArrayList<Director> directorsList;
        ArrayList<Professor> professorsList;

        public Monitor(StudentAdm adm) {
                this.adm = adm;
        }

        
}