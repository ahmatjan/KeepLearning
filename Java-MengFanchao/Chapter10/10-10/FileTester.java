import java.io.File;

public class FileTester
{
	static public void main(String args[])
	{
	//	File f = new File("/home/jason/Desktop/蜜罐资料");
		File f = new File("/home/jason/Desktop/TestFolder");

		String[] s;

		System.out.println("The file is exists?" + f.exists());
		System.out.println("The file is Directory?" + f.isDirectory());
		System.out.println("The absolute path:" + f.getAbsolutePath());
		System.out.println(f.list());
		s = f.list();
		for (int i = 0; i < s.length; i++)
		{
			System.out.println(s[i]);
		}
		System.out.println("The file name:" + f.getName());
	}
}
