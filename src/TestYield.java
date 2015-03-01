
public class TestYield extends Thread {
	public TestYield()
	{
		
	}
	public TestYield(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0; i < 50; i++)
		{
			System.out.println(getName() + "  " + i);
			if (i == 20)
			{
				Thread.yield();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestYield ty1 = new TestYield("gaoji");
		ty1.setPriority(Thread.MAX_PRIORITY);
		ty1.start();
		TestYield ty2 = new TestYield("diji");
		ty2.setPriority(Thread.MIN_PRIORITY);
		ty2.start();

	}

}
