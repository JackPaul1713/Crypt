package actions;

import java.io.IOException;
import java.math.BigInteger;

import resources.EncryptDecrypt;
import resources.FileMakeDelete;
import resources.ReadWrite;
import resources.Converstions;
import resources.Data;

public class EditKey
{
	//genRemKey ADD: encrypt password with key and write it to file as a check for proper password
	public static void genKey(String name, String pw, int size) throws IOException
	{
		//makeFile
		FileMakeDelete.makeFile(Data.LOC + name);
		//genKey
		int[] biteKey = genByteKey(size);
		String key = EncryptDecrypt.encryptKey(biteKey, pw);
		//genPwCheck
		ReadWrite.owriteLine(Data.LOC + name, buffPw(pw));
		String pwCheck = combineInts(EncryptDecrypt.encryptBin(ReadWrite.readBinFile(Data.LOC + name), biteKey));
		//fillFile
		ReadWrite.owriteLine(Data.LOC + name, key + "\n" + pwCheck);
	}
	public static void remKey(String name) throws IOException
	{
		//wipe
		ReadWrite.owriteLine(Data.LOC + name, "");
		//rem
		FileMakeDelete.delFile(Data.LOC + name);
	}
//	public static void testKey(String name, String password)
//	{
//		//getVar
//		String enBiteKey = ReadWrite.readLine(fileName);
//		String enBufPw = ReadWrite.readLine(fileName);
//	}
	
	//dispKeys
	public static void dispKeys()
	{
		
	}
	
	//generate
	private static int[] genByteKey(int size)
	{
		//var
		int[] biteKey = new int[size];
		//generate
		for(int i = 0; i < size; i++)
		{
			biteKey[i] = (int) (Math.random() * 256 + 1);
		}
		//ret
		return(biteKey);
	}
//	private static int[] genBitePwCheck(String pw)
//	{
//		String buffPw = buffPw(pw);
//		int[] bites = Converstions.getBytes(buffPw);
//		return(bites);
//	}
	
	//resources
	private static String combineInts(int[] numbs)
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
		return(strNumb);
	}
	private static String buffPw(String pw)
	{
		String buffPw = genRandomStr(21) + pw + genRandomStr(21);
		return(buffPw);
	}
	private static String genRandomStr(int len)
	{
		final String SYMKEYS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijlmnopqrstuvwxyz1234567890+/";//!@#$%^&*()_+-[]{}|;:',<.>/?\"\\`~";
		String randomStr = "";
		int random;
		for(int l = 0; l < len; l++)
		{
			random = (int) (Math.random() * (SYMKEYS.length()-1));
			randomStr += SYMKEYS.substring(random, random + 1);
		}
		return(randomStr);
	}
}
