package resources;

import java.math.BigInteger;
import resources.Data;

public class EncryptDecrypt
{
	//encryptDecryptBin
	public static int[] encryptBin(int[] bites, int[] biteKey)
	{
		//encrypt
		for(int i = 0; i < bites.length; i++)
		{
			bites[i] += biteKey[i % biteKey.length];
		}
		//ret
		return(bites);
	}
	public static int[] decryptBin(int[] bites, int[] biteKey)
	{
		//decrypt
		for(int i = 0; i < bites.length; i++)
		{
			bites[i] = bites[i] - biteKey[i % biteKey.length];
			while(bites[i] < 0)
			{
				bites[i] = bites[i] + 256;
			}
		}
		//ret
		return(bites);
	}
	
	//encryptDecryptKey
	public static String encryptKey(int[] biteKey, String pw)
	{
		//var
		String enKey;
		BigInteger numbKey = combineInts(biteKey);
		BigInteger numbPw = combineInts(getNumbs(pw));
		BigInteger invNumbPw = invertBigInt(numbPw);
		BigInteger numbEnKey;
		//encrypt
		numbEnKey = numbKey.multiply(numbPw);
		numbEnKey = numbEnKey.add(invNumbPw);
		enKey = numbEnKey.toString();
		//ret
		return(enKey);
	}
	public static int[] decryptKey(String enKey, String pw)
	{
		//var
		BigInteger numbKey;
		BigInteger numbEnKey = new BigInteger(enKey);
		BigInteger numbPw = combineInts(getNumbs(pw));
		BigInteger invNumbPw = invertBigInt(numbPw);
		int[] biteKey;
		//encrypt
		numbKey = numbEnKey.subtract(invNumbPw);
		numbKey = numbKey.divide(numbPw);
		//format
		biteKey = splitBigInt(numbKey);
		//ret
		return(biteKey);
	}
	
	//resources
	private static int[] getNumbs(String str)
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
	private static BigInteger combineInts(int[] numbs)
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
	private static int[] splitBigInt(BigInteger numb)
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
	private static BigInteger invertBigInt(BigInteger numbPw)
	{
		//var
		String strNumb = numbPw.toString();
		String strInvNumb = "";
		//invert
		for(int l = 0; l < strNumb.length(); l++)
		{
			strInvNumb = strNumb.substring(l, l+1) + strInvNumb;
		}
		numbPw = new BigInteger(strInvNumb);
		//ret
		return(numbPw);
	}
	
}
