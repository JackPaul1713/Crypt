package actions;

import java.io.IOException;
import java.math.BigInteger;

import resources.Converstions;
import resources.Data;
import resources.EncryptDecrypt;
import resources.ReadWrite;

public class EncryptDecryptFile
{
	//encryptDecrypt ADD: check for properly encrypted pw
	public static void encryptFile(String path, String keyName, String pw) throws IOException
	{
		//var
		path = setPath(path);
		String enKey = ReadWrite.readLine(Data.KEYS + keyName);
		String enPwCheck = ReadWrite.readLine(Data.KEYS + keyName, 2);
		int[] bites = ReadWrite.readFileBin(path);
		int[] biteKey = EncryptDecrypt.decryptKey(enKey, pw);
		int[] sBiteKey = shortenKey(biteKey);
		String pwCheck;
		//check
		ReadWrite.owriteLine(Data.TEMP, "");
		ReadWrite.writeFileBin(Data.TEMP, EncryptDecrypt.decryptBin(Converstions.splitBigInt(new BigInteger(enPwCheck)), biteKey));
		pwCheck = ReadWrite.readLine(Data.TEMP);
		//clear
		ReadWrite.owriteLine(Data.TEMP, "");
		//encrypt
		if(pwCheck.contains(pw))
		{
			bites = EncryptDecrypt.encryptBin(bites, biteKey);
			bites = EncryptDecrypt.encryptBin(bites, sBiteKey);
			ReadWrite.owriteLine(path, "");
			ReadWrite.writeFileBin(path, bites);
		}
		else
		{
			System.out.println("Invalid password");
		}
	}
	public static void decryptFile(String path, String keyName, String pw) throws IOException
	{
		//var
		path = setPath(path);
		String enKey = ReadWrite.readLine(Data.KEYS + keyName);
		String enPwCheck = ReadWrite.readLine(Data.KEYS + keyName, 2);
		int[] bites = ReadWrite.readFileBin(path);
		int[] biteKey = EncryptDecrypt.decryptKey(enKey, pw);
		int[] sBiteKey = shortenKey(biteKey);
		String pwCheck;
		//check
		ReadWrite.owriteLine(Data.TEMP, "");
		ReadWrite.writeFileBin(Data.TEMP, EncryptDecrypt.decryptBin(Converstions.splitBigInt(new BigInteger(enPwCheck)), biteKey));
		pwCheck = ReadWrite.readLine(Data.TEMP);
		//clear
		ReadWrite.owriteLine(Data.TEMP, "");
		//decrypt
		if(pwCheck.contains(pw))
		{
			bites = EncryptDecrypt.decryptBin(bites, sBiteKey);
			bites = EncryptDecrypt.decryptBin(bites, biteKey);
			ReadWrite.owriteLine(path, "");
			ReadWrite.writeFileBin(path, bites);
		}
		else
		{
			System.out.println("Invalid password");
		}
	}
	
	//resources
	private static String setPath(String path)
	{
		if(!path.contains("\\"))
		{
			path = System.getProperty("user.dir") + "\\" + path;
		}
		return(path);
	}
	
	private static int[] shortenKey(int[] biteKey)
	{
		int[] sBiteKey = new int[biteKey.length-2];
		for(int i = 0; i < biteKey.length-2; i++)
		{
			sBiteKey[i] = biteKey[i];
		}
		return(sBiteKey);
	}
}
