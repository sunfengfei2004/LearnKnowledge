
public class TestDraw {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acct = new Account("1234567", 0);
		new DrawThread("ȡǮ��", acct, 800).start();
		new DepositThread("�����", acct, 800).start();
	}

}
