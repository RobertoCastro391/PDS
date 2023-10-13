package lab08.Ex1.a;

import java.util.List;

public class SharkCompany {
	public static void main(String[] args) {
		
		// ------------- User.Company -------------
		System.out.println("------------- User.Company -------------");
		Company shark = new Company();
		Company.user = User.COMPANY;
		shark.admitPerson("Maria Silva", 1000);
		shark.admitPerson("Manuel Pereira", 900);
		shark.admitPerson("Aurora Machado", 1200);
		shark.admitPerson("Augusto Lima", 1100);
		
		List<Employee> sharkEmps = shark.employees();
		
		for (Employee e : sharkEmps)
			// "talking to strangers", but this is not a normal case
			System.out.println(e.getBankAccount().balance());
		shark.paySalaries(1);
		for (Employee e : sharkEmps) {
			e.getBankAccount().withdraw(500);
			System.out.println(e.getBankAccount().balance());
		}

		// ------------- User.Company -------------
		System.out.println("------------- User.Company -------------");
		Company shark2 = new Company();
		Company.user = User.OWNER;
		shark2.admitPerson("Maria Silva", 1000);
		shark2.admitPerson("Manuel Pereira", 900);
		shark2.admitPerson("Aurora Machado", 1200);
		shark2.admitPerson("Augusto Lima", 1100);
		
		List<Employee> sharkEmps2 = shark2.employees();
		
		for (Employee e : sharkEmps2)
			// "talking to strangers", but this is not a normal case
			System.out.println(e.getBankAccount().balance());
		shark2.paySalaries(1);
		for (Employee e : sharkEmps2) {
			e.getBankAccount().withdraw(500);
			System.out.println(e.getBankAccount().balance());
		}

	}
}