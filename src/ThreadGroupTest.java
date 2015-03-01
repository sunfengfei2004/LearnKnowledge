class TestThread extends Thread
{
	public TestThread(String name)
	{
		super(name);
	}
	public TestThread(ThreadGroup group, String name)
	{
		super(group, name);
	}
	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			System.out.println(getName() + " �̵߳�i����" + i);
		}
	}
}
public class ThreadGroupTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("���߳��������: " + mainGroup.getName());
		System.out.println("���߳����Ƿ��Ǻ�̨�߳�: " + mainGroup.isDaemon());
		new TestThread("���߳�����߳�").start();
		ThreadGroup tg = new ThreadGroup("���߳���");
		tg.setDaemon(true);
		System.out.println("tg�߳����Ƿ��Ǻ�̨�߳���: " + tg.isDaemon());
		TestThread tt = new TestThread(tg, "tg����̼߳�");
		tt.start();
		new TestThread(tg, "tg����߳���").start();

	}

}
