
public class PriorityTest extends Thread {
	public PriorityTest()
	{
		
	}
	public PriorityTest(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0; i < 50; i++)
		{
			System.out.println(getName() + ", PriorityTest is: " + getPriority() + "  " + i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.currentThread().setPriority(6);
		for (int i = 0; i < 30; i++)
		{
			if (i == 10)
			{
				PriorityTest low = new PriorityTest("low");
				low.start();
				System.out.println("current Priority: " + low.getPriority());
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if (i == 20)
			{
				PriorityTest high = new PriorityTest("high");
				high.start();
				System.out.println("current Priority: " + high.getPriority());
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}

	}

}
