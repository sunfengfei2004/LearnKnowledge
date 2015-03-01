class MyExHandler implements Thread.UncaughtExceptionHandler
{
	public void uncaughtException(Thread t, Throwable e)
	{
		System.out.println(t + "线程出现了异常: " + e);
	}
}
public class ExHandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a = 5 / 0;
	}

}
