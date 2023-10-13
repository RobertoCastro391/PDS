package lab07.Ex1;

import java.util.Date;

public class Manager extends DecoratorEmployee {

    public Manager(EmployeeInterface employee) {
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
    
    public void manage() {
        System.out.printf("Empregado: %s trabalha como manager!\n", super.getNome());
    }
}