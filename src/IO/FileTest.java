package IO;

import java.io.File;
import java.io.IOException;

public class FileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("D:\\java\\javaLearn");
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile().getParent());
		File tmpFile = File.createTempFile("aaa", ".txt", file);
		tmpFile.deleteOnExit();
		File newFile = new File(System.currentTimeMillis() + "");
		//newFile.createNewFile();
		newFile.mkdir();
		String[] fileList= file.list();
		for (String fileName : fileList)
		{
			System.out.println(fileName);
		}
		File[] roots = File.listRoots();
		for (File root : roots)
		{
			System.out.println(root);
		}
	}

}
