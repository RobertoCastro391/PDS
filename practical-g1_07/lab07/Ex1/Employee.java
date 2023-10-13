package lab07.Ex1;

import java.util.Date;

public class Employee implements EmployeeInterface {

    private String name;
    private Date startDate = null;
    private Date terminateDate;

    public Employee(String name) {
        this.name = name;
    }

    public void start(Date date) {
        startDate = date;
        System.out.printf("Empregado/a: %s começou a trabalhar em %s!\n", name, date.toString());
    }

    public void terminate(Date date) {
        terminateDate = date;
        System.out.printf("Empregado/a: %s deixou a trabalhar em %s!\n", name, date.toString());
    }

    public void work() {
        if (startDate != null) {
            if (terminateDate == null) {
                System.out.printf("Empregado/a: %s continua a trablhar!\n", name);
            }
            else {
                System.out.printf("Empregado/a: %s já acabou de trabalhar!\n", name);
            }
        }
        else {
            System.out.printf("Empregado/a: %s ainda não começou a trabalhar!\n", name);
        }
    }

    public String getNome() {
        return this.name;
    }

    
}