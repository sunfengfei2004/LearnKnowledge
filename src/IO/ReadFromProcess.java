package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try
		{
			Process p = Runtime.getRuntime().exec("javac");
			br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String buff = null;
			while((buff = br.readLine())  != null)
			{
				System.out.println(buff);
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (br != null)
				{
					br.close();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}

}
