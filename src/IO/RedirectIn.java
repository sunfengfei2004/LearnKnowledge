package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream("RedirectIn.java");
			System.setIn(fis);
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			while (sc.hasNext())
			{
				System.out.println("键盘输入的内容是: " + sc.next());
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if (fis != null)
			{
				try
				{
					fis.close();
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		}

	}

}
