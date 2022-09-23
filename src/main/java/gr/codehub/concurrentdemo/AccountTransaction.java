package gr.codehub.concurrentdemo;

/**
 * Is a runnable that demonstrates the deadlock case
 * @author iracl
 *
 */

public class AccountTransaction implements Runnable{
	
	private Account incomingAccount;
	private Account outgoingAccount;
	/**
	 * 
	 * @param incomingAccount
	 * @param outgoingAccount
	 */
	public AccountTransaction(Account incomingAccount, Account outgoingAccount) {
		this.incomingAccount = incomingAccount;
		this.outgoingAccount = outgoingAccount;
	}
	
	public void run() {
		int amount  = 10;
		synchronized(incomingAccount) {
			System.out.println("withdrawal from "+ incomingAccount.getOwner());
			incomingAccount.setBalance( incomingAccount.getBalance() - amount);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			synchronized(outgoingAccount) {
					System.out.println("deposit to "+ outgoingAccount.getOwner());
					outgoingAccount.setBalance( outgoingAccount.getBalance() + amount);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}	
	}
}
