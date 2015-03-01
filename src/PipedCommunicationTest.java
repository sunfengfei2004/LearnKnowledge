import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

class ReaderThread extends Thread
{
	private PipedReader pr;
	private BufferedReader br;
	public ReaderThread(){}
	public ReaderThread(PipedReader pr)
	{
		this.pr = pr;
		this.br = new BufferedReader(pr);
	}
	
	public void run()
	{
		String buf = null;
		try
		{
			while ((buf = br.readLine()) != null)
			{
				System.out.println(buf);
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
class WriterThread extends Thread
{
	String[] books = new String[]
	{
			"Struts2权威指南",
			"ROR敏捷开发指南",
			"基于J2EE的Ajax宝典",
			"轻量级J2EE企业应用指南"
	};
	private PipedWriter pw;
	public WriterThread() {}
	public WriterThread(PipedWriter pw)
	{
		this.pw = pw;
		
	}
	public void run()
	{
		try
		{
			for (int i = 0; i< 100; i++)
			{
				pw.write(books[i%4] + "\n");
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
				if (pw != null)
				{
					pw.close();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
public class PipedCommunicationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PipedWriter pw = null;
		PipedReader pr = null;
		try
		{
			pw = new PipedWriter();
			pr = new PipedReader();
			pw.connect(pr);
			new WriterThread(pw).start();
			new ReaderThread(pr).start();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

}
