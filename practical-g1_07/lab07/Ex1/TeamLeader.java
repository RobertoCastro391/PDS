package lab07.Ex1;

import java.util.Date;

public class TeamLeader extends DecoratorEmployee {

    public TeamLeader(EmployeeInterface employee) {
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

    public void plan(){
        System.out.printf("Empregado: %s trabalha como planeador!\n", super.getNome());
    }
}