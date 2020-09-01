package resources;

import java.io.IOException;
import java.math.BigInteger;

public class Converstions
{
	//converstions
	public static String getStr(int[] bites) throws IOException
	{
		//var
		String str;
		//getBytes
		ReadWrite.owriteLine(Data.TEMP, "");
		ReadWrite.writeFileBin(Data.TEMP, bites);
		str = ReadWrite.readLine(Data.TEMP);
		//cls
		ReadWrite.owriteLine(Data.TEMP, "");
		//ret
		return(str);
	}
	public static int[] getBytes(String str) throws IOException
	{
		//var
		int[] bites;
		//getBytes
		ReadWrite.owriteLine(Data.TEMP, str);
		bites = ReadWrite.readFileBin(Data.TEMP);
		//cls
		ReadWrite.owriteLine(Data.TEMP, "");
		//ret
		return(bites);
	}
	public static BigInteger combineInts(int[] numbs)
	{
		//var
		String temp;
		String strNumb = "";
		BigInteger bigInt;
		//combine
		for(int n = 0; n < numbs.length; n++)
		{
			bigInt = BigInteger.valueOf(Long.valueOf(numbs[n]));
			temp = bigInt.toString();
			if(temp.length() == 1)
			{
				temp = "00" + temp;
			}
			else if(temp.length() == 2)
			{
				temp = "0" + temp;
			}
			strNumb += temp;
		}
		//ret
		return(new BigInteger(strNumb));
	}
	public static int[] splitBigInt(BigInteger numb)
	{
		//var
		String strNumb = numb.toString();
		int[] numbs;
		int length;
		//split
		while(strNumb.length() % 3 != 0)
		{
			strNumb = "0" + strNumb;
		}
		numbs = new int[strNumb.length()/3];
		length = strNumb.length();
		for(int n = 0; n < length/3; n++)
		{
			numbs[n] = Integer.parseInt(strNumb.substring(0, 3));
			strNumb = strNumb.substring(3, strNumb.length());
		}
		//ret
		return(numbs);
	}
}
