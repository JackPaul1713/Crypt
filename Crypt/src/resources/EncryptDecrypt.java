package resources;

import java.io.IOException;
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
			while(bites[i] > 255)
			{
				bites[i] = bites[i] - 256;
			}
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
	public static String encryptKey(int[] biteKey, String pw) throws IOException
	{
		//var
		String enKey;
		BigInteger numbKey = Converstions.combineInts(biteKey);
		BigInteger numbPw = Converstions.combineInts(Converstions.getBytes(pw));
		BigInteger invNumbPw = invertBigInt(numbPw);
		BigInteger numbEnKey;
		//encrypt
		numbEnKey = numbKey.multiply(numbPw);
		numbEnKey = numbEnKey.add(invNumbPw);
		enKey = numbEnKey.toString();
		//ret
		return(enKey);
	}
	public static int[] decryptKey(String enKey, String pw) throws IOException
	{
		//var
		BigInteger numbKey;
		BigInteger numbEnKey = new BigInteger(enKey);
		BigInteger numbPw = Converstions.combineInts(Converstions.getBytes(pw));
		BigInteger invNumbPw = invertBigInt(numbPw);
		int[] biteKey;
		//encrypt
		numbKey = numbEnKey.subtract(invNumbPw);
		numbKey = numbKey.divide(numbPw);
		//format
		biteKey = Converstions.splitBigInt(numbKey);
		//ret
		return(biteKey);
	}
	
	//resources
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
