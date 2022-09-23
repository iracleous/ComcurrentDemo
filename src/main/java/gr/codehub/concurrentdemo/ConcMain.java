package gr.codehub.concurrentdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcMain {
	
	public static void main(String [] args) throws InterruptedException, Exception {
		
		List<String> list = Arrays.asList("a", "b", "c", "d");
		
		List<String> syncCollection = Collections.synchronizedList(list);
		List<String> uppercasedCollection = new ArrayList<>();
		
		Runnable listOperations = () -> {
		    synchronized (syncCollection) {
		        syncCollection.forEach((e) -> {
		            uppercasedCollection.add(e.toUpperCase());
		        });
		    }
		};
		
		Thread thread = new Thread(listOperations);
		thread.start();
		
		thread.join();
		
		System.out.println(uppercasedCollection);
		
		/////////////////////////////////////////////////////////////////////
		
		ExecutorService executor1 = Executors.newFixedThreadPool(10);
		
		Callable<String> listOperations2 = () -> {
		    synchronized (syncCollection) {
		        syncCollection.forEach((e) -> {
		            uppercasedCollection.add(e.toUpperCase());
		        });
		    }
		    return "";
		};
		
		Future<String> thread2 =  executor1.submit(listOperations2);
	 
		String result = thread2.get();
		System.out.println(uppercasedCollection);
		
	}

}
