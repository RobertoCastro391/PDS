package Ex2;

abstract class Employee {
	protected String name;
	public abstract String getName();
}

class Programmer extends Employee {
	public Programmer(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return "Employee " + name + " is a employee!";
	}
}

class EmployeeFactory {
	public static final String[] names = { "Roberto", "Tiago", "Sara", "Rafaela" };

	public static Employee getEmployee(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equalsIgnoreCase(name)) {
				return new Programmer(name);
			}
		}
		return new NullRequest(name);
	}
}

class NullRequest extends Employee {
	private String name;

	public NullRequest(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return "Employee " + this.name + " not found";
	}
}

public class NullDemo {
	public static void main(String[] args) {

		Employee emp = EmployeeFactory.getEmployee("Sara");
		Employee emp2 = EmployeeFactory.getEmployee("Rafeala");
		Employee emp3 = EmployeeFactory.getEmployee("Tiago");
		Employee emp4 = EmployeeFactory.getEmployee("Lia");
		Employee emp5 = EmployeeFactory.getEmployee("Renato");
		Employee emp6 = EmployeeFactory.getEmployee("Roberto");
		Employee emp7 = EmployeeFactory.getEmployee("Matilde");

		System.out.println(emp.getName());
		System.out.println(emp2.getName());
		System.out.println(emp3.getName());
		System.out.println(emp4.getName());
		System.out.println(emp5.getName());
		System.out.println(emp6.getName());
		System.out.println(emp7.getName());
	}
}
