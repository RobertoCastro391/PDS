package lab07.Ex1;

import java.util.Date;

public abstract class DecoratorEmployee implements EmployeeInterface {

    protected EmployeeInterface employee;
    
    public DecoratorEmployee(EmployeeInterface employee) {
        this.employee = employee;
    }
    
    @Override
    public String getNome() {
        return employee.getNome();
    }

    @Override
    public void start(Date date) {
        employee.start(date);        
    }

    @Override
    public void terminate(Date date) {
        employee.terminate(date);
    }

    @Override
    public void work() {
        employee.work();
        
    }
}
