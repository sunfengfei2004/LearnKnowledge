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
				System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票： " + drawAmount);
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println("\t余额为： " + balance);
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
				System.out.println(Thread.currentThread().getName() + "取钱:" + drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为: " + balance);
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
				System.out.println(Thread.currentThread().getName() + "存款: " + depositAmount);
				balance += depositAmount;
				System.out.println("账户余额为: " + balance);
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
