package lab06.EX1;
    
import java.util.*;

public class Registos{

    private ArrayList<Empregado> empregados;


    public Registos () {
        empregados = new ArrayList<>();
    }

    public void insere (Empregado emp) {
        if (!isEmpregado(emp.codigo()))
            empregados.add(emp);
    }
    public void remove (int codigo) {
        for(Empregado empregado_para_ver : empregados){

            if(empregado_para_ver.codigo() == codigo){
                empregados.remove(empregado_para_ver); 
                break;
            }
        }
    }

    public boolean isEmpregado (int codigo) {
        for(Empregado empregado_para_ver : empregados){
            if(empregado_para_ver.codigo() == codigo){ return true;}
        }
        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        return empregados;
    }

    @Override
    public String toString() {
        return "Registos " + empregados;
    }
   
}
