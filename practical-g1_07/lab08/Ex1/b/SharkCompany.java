package lab08.Ex1.b;
import java.util.List;

public class SharkCompany {
	public static void main(String[] args ) {

		Person[] persons = { new Person("Maria Silva"),
					new Person("Manuel Pereira"),
					new Person("Aurora Machado"),
					new Person("Augusto Lima") };
		// ------------- User.Company -------------
		System.out.println("------------- User.Company -------------");

		Company shark = new Company();
		Company.user= User.OWNER;
		shark.admitEmployee(persons[0], 1000);
		shark.admitEmployee(persons[1], 900);
		shark.admitEmployee(persons[2], 1200);
		shark.admitEmployee(persons[3], 1100);
		
		List<Employee> sharkEmps = shark.employees();

		for (Employee e: sharkEmps)
			System.out.println(e.getSalary());
		
		shark.paySalaries(1);
		for (Employee e : sharkEmps) {
            System.out.println(e.getBank().balance());
        }

		// ------------- User.Company -------------
		System.out.println("------------- User.Company -------------");

		Company shark2 = new Company();
		Company.user= User.COMPANY;
		shark2.admitEmployee(persons[0], 1000);
		shark2.admitEmployee(persons[1], 900);
		shark2.admitEmployee(persons[2], 1200);
		shark2.admitEmployee(persons[3], 1100);
		
		List<Employee> sharkEmps2 = shark2.employees();

		for (Employee e: sharkEmps2)
			System.out.println(e.getSalary());
		
		shark.paySalaries(1);
		for (Employee e : sharkEmps2) {
            System.out.println(e.getBank().balance());
        }
		
	}
}