package resources;

public class Converstions
{
	//converstions
	public static String getStr(int[] bites)
	{
		//var
		String temp;
		String str = "";
		//convert
		for(int i = 0; i < bites.length; i++)
		{
			temp = Integer.toString(bites[i]);
			if(temp.length() == 1)
			{
				temp = temp + "00";
			}
			else if(temp.length() == 2)
			{
				temp = temp + "0";
			}
			str += temp;
		}
		//ret
		return(str);
	}
	public static int[] getNumbs(String str)
	{
		//var
		String[] letts = str.split("");
		int[] numbs = new int[letts.length];
		//switch
		for(int l = 0; l < letts.length; l++)
		{
			for(int a = 0; a < Data.SYMBKEYS.length; a++)
			{
				if(letts[l].equals(Data.SYMBKEYS[a]))
				{
					numbs[l] = Data.NUMBKEYS[a];
				}
			}
		}
		//ret
		return(numbs);
	}
	public static int[] getBytes(String str)
	{
		//var
		byte[] bites = str.getBytes();
		int[] intBites = new int[bites.length];
		//convert
		for(int i = 0; i < bites.length; i++)
		{
			intBites[i] = bites[i] & 0xFF;
		}
		return(intBites);
	}
}
