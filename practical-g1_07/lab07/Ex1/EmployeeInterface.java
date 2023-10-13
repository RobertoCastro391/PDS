package lab07.Ex1;

import java.util.Date;

public interface EmployeeInterface {
    public void start(Date date);
    public void terminate(Date date);
    public void work();
    public String getNome();
}