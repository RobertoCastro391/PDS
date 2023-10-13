package lab06.EX1;

import java.util.Vector;

public class Database {

    // Data elements
    private Vector<Employee> employees ; // Stores the employees
   
    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee ) {
        // Code to add employee
        return  employees.add(employee);
    }

    public void deleteEmployee(long emp_num) {
        // Code to delete employee
        for(Employee employee_to_check : employees){
            if(employee_to_check.getEmpNum() == emp_num){employees.remove(employee_to_check); break;}
        }
    }

    public Employee[] getAllEmployees(){
        
        Employee[] employeeArray = new Employee[employees.size()];

        for (int i=0; i < employees.size(); i++) {
            employeeArray[i] = employees.get(i);
        }

        return employeeArray;
    }

    public boolean isEmployee(long code) {
        for (int i = 0; i < employees.size(); i++) {
            if (code == employees.get(i).getEmpNum()) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Database: " + employees;
    }
}