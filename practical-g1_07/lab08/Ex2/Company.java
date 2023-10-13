package lab08.Ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Company {

public static User user;
private List<Employee> emps = new ArrayList<>();

	public void admitPerson(String name, double salary) {
		Employee e = new Employee(name, salary);
		emps.add(e);
		
		SocialSecurity.regist(e);
		Insurance.regist(e);
		Card.regist(e);
		Parking.allow(e);
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}