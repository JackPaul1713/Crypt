package resources;

import java.io.File;
import java.io.IOException;

public class FileMakeDelete
{
	//makeDelete
	public static void makeFile(String name) throws IOException
	{
		File file = new File(name);
		file.createNewFile();
	}
	public static void delFile(String name)
	{
		File file = new File(name);
		file.delete();
	}
}
