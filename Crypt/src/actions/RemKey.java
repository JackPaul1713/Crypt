package actions;

import resources.Data;
import resources.FileMakeDelete;

public class RemKey
{
	//remKey
	public static void remKey(String name)
	{
		//rem
		FileMakeDelete.delFile(Data.LOC + name);
	}
}
