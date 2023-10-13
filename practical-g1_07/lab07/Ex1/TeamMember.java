package lab07.Ex1;

import java.util.Date;

public class TeamMember extends DecoratorEmployee {

    public TeamMember(EmployeeInterface employee) {
        super(employee);
    }

    public String getNome() {
        return super.getNome();
    }

    public void start(Date date) {
        super.start(date);
    }

    public void terminate(Date date) {
        super.terminate(date);
    }

    public void work() {
        super.work();
    }

    public void colaborate(){
        System.out.printf("Empregado: %s trabalha como colaborador!\n", super.getNome());
    }
}