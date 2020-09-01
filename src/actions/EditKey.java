package actions;

import java.io.File;
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
		FileMakeDelete.makeFile(Data.KEYS + name);
		//genKey
		int[] biteKey = genByteKey(size);
		String key = EncryptDecrypt.encryptKey(biteKey, pw);
		String pwCheck;
		//genPwCheck
		ReadWrite.owriteLine(Data.KEYS + name, buffPw(pw));
		pwCheck = combineInts(EncryptDecrypt.encryptBin(ReadWrite.readFileBin(Data.KEYS + name), biteKey));
		//fillFile
		ReadWrite.owriteLine(Data.KEYS + name, key + "\n" + pwCheck);
	}
	public static void remKey(String name) throws IOException
	{
		//wipe
		ReadWrite.owriteLine(Data.KEYS + name, "");
		//rem
		FileMakeDelete.delFile(Data.KEYS + name);
	}
	
	//changeKey
	public static void changeName(String name, String newName)
	{
		File key = new File(Data.KEYS + name);
		key.renameTo(new File(Data.KEYS + newName));
	}
	public static void changePw(String name, String oldPw, String newPw) throws IOException
	{
		//var
		String key = ReadWrite.readLine(Data.KEYS + name);
		int[] biteKey = EncryptDecrypt.decryptKey(key, oldPw);
		String enOldPwCheck = ReadWrite.readLine(Data.KEYS + name, 2);
		String oldPwCheck;
		String newPwCheck;
		//checkOld
		ReadWrite.owriteLine(Data.TEMP, "");
		ReadWrite.writeFileBin(Data.TEMP, EncryptDecrypt.decryptBin(Converstions.splitBigInt(new BigInteger(enOldPwCheck)), biteKey));
		oldPwCheck = ReadWrite.readLine(Data.TEMP);
		//clear
		ReadWrite.owriteLine(Data.TEMP, "");
		//fillFile
		if(oldPwCheck.contains(oldPw))
		{
			//genNewPwCheck
			ReadWrite.owriteLine(Data.TEMP, buffPw(newPw));
			newPwCheck = combineInts(EncryptDecrypt.encryptBin(ReadWrite.readFileBin(Data.TEMP), biteKey));
			key = EncryptDecrypt.encryptKey(biteKey, newPw);
			ReadWrite.owriteLine(Data.KEYS + name, key + "\n" + newPwCheck);
			//clear
			ReadWrite.owriteLine(Data.TEMP, "");
		}
		else
		{
			System.out.println("Invalid password");
		}
	}

	//dispKeys
	public static void listKeys()
	{
		File dir = new File(Data.KEYS);
		File[] files = dir.listFiles(); 
		for(File f: files)
		{
			System.out.println(f.getName());
		}
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
		String buffPw = genRandomStr(41) + pw + genRandomStr(41);
		return(buffPw);
	}
	private static String genRandomStr(int len)
	{
		final String SYMKEYS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijlmnopqrstuvwxyz1234567890+/!@#$%^&*()_+-[]{}|;:',<.>/?\"\\`~";
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
