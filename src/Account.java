import java.util.concurrent.locks.ReentrantLock;


public class Account {
	//private final ReentrantLock lock = new ReentrantLock();
	private String accountNo;
	private double balance;
	private boolean flag = false;
	
	public Account() {}
	public Account(String accountNo, double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	public double getBalance()
	{
		return balance;
	}
	public String getAccountNo()
	{
		return accountNo;
	}
	public int hashcode()
	{
		return accountNo.hashCode();
	}
	
	public boolean equals(Object obj)
	{
		if (obj != null && obj.getClass() == Account.class)
		{
			Account target = (Account)obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
	
/*	public synchronized void draw(double drawAmount)
	{
		lock.lock();
		try
		{
			if (balance >= drawAmount)
			{
				System.out.println(Thread.currentThread().getName() + "ȡǮ�ɹ����³���Ʊ�� " + drawAmount);
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println("\t���Ϊ�� " + balance);
			}
		}
		finally
		{
			lock.unlock();
		}
		
	}*/
	public synchronized void draw(double drawAmount)
	{
		try
		{
			if (!flag)
			{
				wait();
			}
			else
			{
				System.out.println(Thread.currentThread().getName() + "ȡǮ:" + drawAmount);
				balance -= drawAmount;
				System.out.println("�˻����Ϊ: " + balance);
				flag = false;
				notifyAll();
			}
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount)
	{
		try
		{
			if (flag)
			{
				wait();
			}
			else
			{
				System.out.println(Thread.currentThread().getName() + "���: " + depositAmount);
				balance += depositAmount;
				System.out.println("�˻����Ϊ: " + balance);
				flag = true;
				notifyAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}

}
