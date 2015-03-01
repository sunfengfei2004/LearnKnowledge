package IO;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomAccessFile raf = null;
		try
		{
			raf = new RandomAccessFile("RandomAccessFileTest.java", "r");
			System.out.println("RandomAccessFile的文件指针的初始位置: " + raf.getFilePointer());
			raf.seek(300);
			byte[] bbuf = new byte[1024];
		}
	}

}
