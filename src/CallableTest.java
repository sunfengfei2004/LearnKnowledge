import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class RtnThread implements Callable<Integer>
{
	public Integer call()
	{
		int i = 0;
		for ( ; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值: " + i);
		}
		return i;
	}
}
public class CallableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RtnThread rt = new RtnThread();
		FutureTask<Integer> task = new FutureTask<Integer>(rt); 
		for (int i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值: " + i);
			if (i == 20)
			{
				new Thread(task, "有返回值得线程").start();
			}
		}
		try
		{
			System.out.println("子线程的返回值: " + task.get());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
