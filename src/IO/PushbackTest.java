package IO;

import java.io.FileReader;
import java.io.PushbackReader;

public class PushbackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PushbackReader pr = null;
		try
		{
			pr = new PushbackReader(new FileReader("PushbackTest.java"), 64);
			char[] buf = new char[32];
			String lastContent = "";
			int hasRead = 0;
			while ((hasRead = pr.read(buf)) > 0)
			{
				String content = new String(buf, 0, hasRead);
				int targetIndex = 0;
				if ((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0)
				{
					pr.unread((lastContent + content).toCharArray());
					pr.read(buf, 0, targetIndex);
					System.out.println(new String(buf, 0, targetIndex));
					System.exit(0);
				}
			}
		}

	}

}
