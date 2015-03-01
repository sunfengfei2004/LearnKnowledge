import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class RtnThread implements Callable<Integer>
{
	public Integer call()
	{
		int i = 0;
		for ( ; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName() + " ��ѭ������i��ֵ: " + i);
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
			System.out.println(Thread.currentThread().getName() + " ��ѭ������i��ֵ: " + i);
			if (i == 20)
			{
				new Thread(task, "�з���ֵ���߳�").start();
			}
		}
		try
		{
			System.out.println("���̵߳ķ���ֵ: " + task.get());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
