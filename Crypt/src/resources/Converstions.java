package resources;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Converstions
{
	//converstions
	public static String getStr(int[] intBites)
	{
		byte[] bites = new byte[intBites.length];
		for(int i = 0; i < bites.length; i++)
		{
			bites[i] = (byte) intBites[i];
		}
		String str = Base64.getEncoder().encodeToString(bites);
		return(str);
	}
	public static int[] getBytes(String str)
	{
		//var
		byte[] bites = Base64.getDecoder().decode(str);
		int[] intBites = new int[bites.length];
		//convert
		for(int i = 0; i < bites.length; i++)
		{
			intBites[i] = bites[i] & 0xFF;
		}
		return(intBites);
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
