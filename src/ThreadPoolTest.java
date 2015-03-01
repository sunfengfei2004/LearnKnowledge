import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TestThreadd implements Runnable
{
	public TestThreadd(){}
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName() + "µÄiÖµÎª: " + i);
		}
	}
}
public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService pool = Executors.newFixedThreadPool(6);
		pool.submit(new TestThreadd());
		pool.submit(new TestThreadd());
		pool.shutdown();
	}

}
