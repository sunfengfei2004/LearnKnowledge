package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try
		{
			InputStreamReader reader = new InputStreamReader(System.in);
			br = new BufferedReader(reader);
			String buffer = null;
			while ((buffer = br.readLine()) != null)
			{
				if (buffer.equals("exit"))
				{
					System.exit(1);
				}
				System.out.println(" ‰»Îƒ⁄»›Œ™:" + buffer);
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
	}

}
