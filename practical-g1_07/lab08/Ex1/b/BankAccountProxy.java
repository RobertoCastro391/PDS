package lab08.Ex1.b;


class BankAccountProxy implements BankAccount {
	
	private BankAccountImpl bank;

	BankAccountProxy(String bank, double initialDeposit) {
		this.bank = new BankAccountImpl(bank, initialDeposit);
	}

	@Override
	public double balance() {
		if (Company.user == User.OWNER) {
			return this.bank.balance();
		}
		else {
			System.out.println("Operation not authorized!");
		}
		return 0;
	}

	@Override
	public void deposit(double amount) {
		this.bank.deposit(amount);
	}

	@Override
	public boolean withdraw(double amount) {
		if (Company.user == User.OWNER) {
			this.bank.withdraw(amount);
			return true;
		}
		else {
			System.out.println("Operation not authorized!");
			return false;
		}
	}
}