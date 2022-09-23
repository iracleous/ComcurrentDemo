package gr.codehub.concurrentdemo;

import java.util.concurrent.Callable;

public class CallableAccount implements Callable<Account>{

	private static final String NAME = "Dimitris";
	private static final int BALANCE = 1000;
	
	
	public Account call() throws Exception {
		
		Account account = new Account();
		account.setOwner(NAME);
		account.setBalance(BALANCE);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return account;
	}

}
