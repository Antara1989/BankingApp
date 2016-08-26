package com.capgemini.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.times;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
public class AccountTest {

	AccountService accountService ;
	
	@Mock
	AccountRepository accountRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepository);
	}

	/*  create account
	 *  1.when the amount is less than 500 system should throw exception
	 *  2.when the valid info is passed account should be created successfully
	 */
	
	
	@Test(expected = com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsufficientInitialBalanceException
	{
		accountService.createAccount(101, 200);
	}
	
	
	
	@Ignore
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientInitialBalanceException
	{
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
		when(accountRepository.save(account)).thenReturn(true);
		
		assertEquals(account,accountService.createAccount(101, 5000));
		
	}
	
	
	@Test
	public void testShowAccountBalance_Positive() throws  InvalidAccountNumberException
	{
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
		when(accountRepository.searchAccount(Mockito.anyInt())).thenReturn(account);
		assertEquals(5000,accountService.showBalance(101));
		//accountService.showBalance(101);
		Mockito.verify(accountRepository).searchAccount(Mockito.anyInt());
		//assertEquals(5000,accountService.showBalance(101));
		
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void testShowAccountBalance_Negetive() throws  InvalidAccountNumberException
	{
		Account account = new Account();
		account.setAccountNumber(-101);
		account.setAmount(5000);
		
		when(accountRepository.searchAccount(Mockito.anyInt())).thenReturn(account);
		//assertEquals(5000,accountService.showBalance(101));
		accountService.showBalance(-101);
		//Mockito.verify(accountRepository).searchAccount(Mockito.anyInt());
		//assertEquals(5000,accountService.showBalance(101));
		
	}
	@Test
	public void testDepositAmount_Positive() throws  InvalidAccountNumberException
	{
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
		when(accountRepository.searchAccount(Mockito.anyInt())).thenReturn(account);
		
		accountService.depositAmount(101, 50);
		assertEquals(5050,accountService.showBalance(101));
		
		Mockito.verify(accountRepository,times(2)).searchAccount(Mockito.anyInt());
		
	}
	
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void testDepositAmount_Negetive() throws  InvalidAccountNumberException
	{
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
		when(accountRepository.searchAccount(Mockito.anyInt())).thenReturn(account);
		
		accountService.depositAmount(-101, 50);
		
		Mockito.verify(accountRepository,times(1)).searchAccount(Mockito.anyInt());
		
	}
	
	
	
	@Test//(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void testWithdrawAmount_Positive() throws  InvalidAccountNumberException, InsufficientBalanceException
	{
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
		when(accountRepository.searchAccount(Mockito.anyInt())).thenReturn(account);
		
		accountService.withdrawAmount(101, 50);
		assertEquals(4950,accountService.showBalance(101));
		
		Mockito.verify(accountRepository,times(2)).searchAccount(Mockito.anyInt());
		
	}
	
	
	
	
	
	
	
	
	

}
