package IO;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(".");
		String[] nameList = file.list(new MyFilenameFilter());
		
		for (String name : nameList)
		{
			System.out.println(name);
		}
	}

}

class MyFilenameFilter implements FilenameFilter
{
	public boolean accept(File dir, String name)
	{
		return name.endsWith(".java") || new File(name).isDirectory();
	}
}
