package actions;

import resources.Data;
import resources.FileMakeDelete;

public class DelKey
{
	//delKey
	public static void delKey(String name)
	{
		//del
		FileMakeDelete.delFile(Data.LOC + name);
	}
}
