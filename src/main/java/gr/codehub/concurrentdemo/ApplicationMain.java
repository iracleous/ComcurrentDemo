package gr.codehub.concurrentdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ApplicationMain {
	
	public static void main(String[] args)   {
		
		ExecutorService executor1 = Executors.newFixedThreadPool(10);
		List<Future<Account>> futures = new ArrayList<>();
		
		for (int i = 0 ; i<100 ; i++) {
			CallableAccount myCall = new CallableAccount();
			futures.add(executor1.submit(myCall)) ;
		}
		
		for (Future<Account> faccount:futures) {	
			Account account = null;
			try {
			 account = faccount.get();
			}
			catch(Exception e) {
				System.out.println("future exception occured");
				continue;
			}
			System.out.println(account.getOwner() + "  " + account.getBalance());
		}
		
		executor1.shutdown();
	}
}
