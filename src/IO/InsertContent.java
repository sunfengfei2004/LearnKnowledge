package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	
	public static void insert(String fileName, long pos, String insertContent) throws IOException
	{
		RandomAccessFile raf = null;
		File tmp = File.createTempFile("tmp", null);
		FileOutputStream tmpOut = null;
		FileInputStream tmpIn = null;
		tmp.deleteOnExit();
		try
		{
			raf = new RandomAccessFile(fileName, "rw");
			tmpOut = new FileOutputStream(tmp);
			tmpIn = new FileInputStream(tmp);
			raf.seek(pos);
			byte[] bbuf = new byte[64];
			int hasRead = 0;
			while ((hasRead = raf.read(bbuf)) > 0)
			{
				tmpOut.write(bbuf, 0, hasRead);
			}
			raf.seek(pos);
			raf.write(insertContent.getBytes());
			while ((hasRead = tmpIn.read(bbuf)) >0)
			{
				raf.write(bbuf, 0, hasRead);
			}
		}
		finally
		{
			raf.close();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
