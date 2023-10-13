package lab08.Ex1.b;

class Employee {

	private double salary;
	private Person person;
	private BankAccount bank;
	
	public Employee(Person person, double s) {
		this.person = person;
		salary = s;
		bank = new BankAccountProxy("PeDeMeia", 0);
	}

	public double getSalary() {
		return salary;
	}

	public Person getPerson() {
		return person;
	}

	public BankAccount getBank() {
		return bank;
	}
}