package assignment1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankAccountTest 
{
	
	 @Test 
	 public void testgetBalance()
	 { 
	    BankAccount bankaccount = new BankAccount(150);//Account balance is $150 
	    assertEquals(150,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $150 
	 }
	 
	@Test 
	 public void testgetBalanceZeroBalance() 
	 { 
		BankAccount bankaccount = new BankAccount(0);//Account balance is $0 
		assertEquals(0,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $0 
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void testgetNegativeValue() 
	 { 
		BankAccount bankaccount = new BankAccount(-150);//Should throw an exception for negative initial balance
		
	 }
	
	 @Test(expected = IllegalArgumentException.class) 
	 public void testgetBalanceMultipleTransaction() 
	 { 
		 BankAccount bankaccount = new BankAccount(1000);//Account balance is $1000
		 bankaccount.deposit(90);//User deposits $90
		 bankaccount.deposit(0);//User deposits $0
		 bankaccount.deposit(190);//User deposits $190
		 assertEquals(1280,bankaccount.getBalance(),0.001);//Verify if the AccountBalance is $1280
	 }
	 
	 @Test
	 public void deposit() 
	 { 
	    BankAccount bankaccount = new BankAccount(10);//Account balance is $10 
	    bankaccount.deposit(90);//Deposit of $90
	    assertEquals(100,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $100
	 }
	  
	 @Test(expected = IllegalArgumentException.class)
	 public void depositNegativeBalance()
	 { 
		BankAccount bankaccount = new BankAccount(-40);//Account balance is $-40
		bankaccount.deposit(100);//Deposit of $100
	    assertEquals(60,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $60
	 }
	 
	 @Test
	 public void depositSmallPositiveValue()
	 {
		BankAccount bankaccount = new BankAccount(0.25);//Account balance is $100
		bankaccount.deposit(90);//Deposit of $90
		assertEquals(90.25,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $90.25
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void depositNegativeTest()
	 {
		BankAccount bankaccount = new BankAccount(100);//Account balance is $100
		bankaccount.deposit(-50);//Should throw an exception for negative deposit
	 }
	 
	 @Test
	 public void testWithdrawValidAmount()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.withdraw(450);//Withdraw $450
		assertEquals(450,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $450
	 }
	 
	 @Test
	 public void testWithdrawValidBalance()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.withdraw(900);//Withdraw entire balance
		assertEquals(0,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $0
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void testWithdrawMoreAmount()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.withdraw(1000);// Should throw an exception
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void testWithdrawNegativeAmount()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.withdraw(-10);// Should throw an exception
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void testWithdrawZeroAmount()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.withdraw(0);// Should throw an exception
	 }
	 
	 @Test
	 public void testWithdrawPostDeposit()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.deposit(500);//Deposit $500
		bankaccount.withdraw(900);//Withdraw $900
		assertEquals(500,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $500
	 }
	 
	 @Test
	 public void testWithdrawMultipleWithdraw()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.withdraw(500);//Withdraw $500
		bankaccount.withdraw(300);//Withdraw $300
		assertEquals(100,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $100
	 }
	 
	 @Test
	 public void testWithdrawMultipleWithdrawDeposit()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.withdraw(500);//Withdraw $500
		bankaccount.deposit(500);//Deposit $500
		bankaccount.withdraw(300);//Withdraw $300
		bankaccount.deposit(500);//Deposit $500
		assertEquals(1100,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $1100
	 }
	 
	 @Test
	 public void testDepositthenWithdraw()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.deposit(500);//Deposit $500
		bankaccount.withdraw(300);//Withdraw $300
		assertEquals(1100,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $1100
	 }
	 
	 @Test
	 public void testWithdrawthenDeposit()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.withdraw(300);//Withdraw $300
		bankaccount.deposit(500);//Deposit $500
		assertEquals(1100,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $1100
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void testWithdrawMoreThanDeposited()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.deposit(500);//Deposit $500
		bankaccount.withdraw(1500);// Should throw an exception
	 }
	 
	 @Test
	 public void testWithdrawAllthenDeposit()
	 {
		BankAccount bankaccount = new BankAccount(900);//Account balance is $900
		bankaccount.withdraw(900);//Withdraw $900
		bankaccount.deposit(500);//Deposit $500
		assertEquals(500,bankaccount.getBalance(),0.001);//Verify if the Account Balance is $500
	 } 
}
