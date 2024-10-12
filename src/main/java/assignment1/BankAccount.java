package assignment1;

public class BankAccount 
{
	private double balance;
	public BankAccount(double initialBalance) 
	{
	 if (initialBalance < 0) 
	 {
	 throw new IllegalArgumentException("Initial balance cannot be negative");
	 }
	 this.balance = initialBalance;
	}
	
	public double getBalance() //BALANCE
	{
	 return balance;
	}
	public void deposit(double amount) //DEPOSIT
	{
	 if (amount <= 0) 
	 {
	 throw new IllegalArgumentException("Deposit amount must be positive");
	 }
	 balance += amount;
	}
	public void withdraw(double amount) //WITHDRAW
	{
	 if (amount <= 0) 
	 {
	 throw new IllegalArgumentException("Withdrawal amount must be positive");
	 }
	 if (amount > balance) 
	 {
	 throw new IllegalArgumentException("Insu?icient funds");
	 }
	 balance -= amount;
	}
}


