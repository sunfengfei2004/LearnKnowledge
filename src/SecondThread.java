
public class SecondThread implements Runnable{
	private int  i;
	public void run()
	{
		for ( ; i < 100 ; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName() + "  " + i);
			if (i == 20)
			{
				SecondThread st = new SecondThread();
				new Thread(st, "new Thread 1").start();
				new Thread(st, "new Thread 2").start();
			}
		}

	}

}
