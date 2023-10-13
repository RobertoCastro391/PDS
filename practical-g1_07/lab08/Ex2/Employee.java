package lab08.Ex2;

class Employee extends Person {

	private double salary;
	private Card cardEmployee;
	
	public Employee(String n, double s) {
		super(n);
		salary = s;
	}

	public double getSalary() {
		return salary;
	}

	public void addCard(Card card) {
		this.cardEmployee = card;
	}
}