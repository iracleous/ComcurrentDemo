package gr.codehub.concurrentdemo;

public class Main {
	private static int meter;
	public static void main(String []args) throws Exception{

		Account accountA = new Account();
		accountA.setOwner("Ercan");
		accountA.setBalance(1000);
		
		Account accountB = new Account();
		accountB.setOwner("Aris");
		accountB.setBalance(500);
		
		
		AccountTransaction work1 = new AccountTransaction(accountA, accountB);
		AccountTransaction work2 = new AccountTransaction(accountB, accountA);
		
		Thread t1 = new Thread(work1);
		Thread t2 = new Thread(work2);
		
		t1.start();
		try {
		Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		
		 
		t1.join();
		t2.join();
		
	}
}
