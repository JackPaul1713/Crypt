package actions;

import java.io.File;
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
		String enKey = ReadWrite.readLine(Data.LOC + keyName);
		String enPwCheck = ReadWrite.readLine(Data.LOC + keyName, 2);
		int[] bites = ReadWrite.readBinFile(path);
		int[] biteKey = EncryptDecrypt.decryptKey(enKey, pw);
		String pwCheck;
		//check
		ReadWrite.owriteLine(Data.LOC + keyName, "");
		ReadWrite.writeBinFile(Data.LOC + keyName, EncryptDecrypt.decryptBin(Converstions.splitBigInt(new BigInteger(enPwCheck)), biteKey));
		pwCheck = ReadWrite.readLine(Data.LOC + keyName);
		//encrypt
		if(pwCheck.contains(pw))
		{
			bites = EncryptDecrypt.encryptBin(bites, biteKey);
			ReadWrite.owriteLine(path, "");
			ReadWrite.writeBinFile(path, bites);
		}
		else
		{
			System.out.println("Invalid password");
		}
		//rewrite
		ReadWrite.owriteLine(Data.LOC + keyName, "");
		ReadWrite.owriteLine(Data.LOC + keyName, enKey + "\n" + enPwCheck);
	}
	public static void decryptFile(String path, String keyName, String pw) throws IOException
	{
		//var
		path = setPath(path);
		String enKey = ReadWrite.readLine(Data.LOC + keyName);
		String enPwCheck = ReadWrite.readLine(Data.LOC + keyName, 2);
		int[] bites = ReadWrite.readBinFile(path);
		int[] biteKey = EncryptDecrypt.decryptKey(enKey, pw);
		String pwCheck;
		//check
		ReadWrite.owriteLine(Data.LOC + keyName, "");
		ReadWrite.writeBinFile(Data.LOC + keyName, EncryptDecrypt.decryptBin(Converstions.splitBigInt(new BigInteger(enPwCheck)), biteKey));
		pwCheck = ReadWrite.readLine(Data.LOC + keyName);
		//decrypt
		if(pwCheck.contains(pw))
		{
			bites = EncryptDecrypt.decryptBin(bites, biteKey);
			ReadWrite.owriteLine(path, "");
			ReadWrite.writeBinFile(path, bites);
		}
		else
		{
			System.out.println("Invalid password");
		}
		//rewrite
		ReadWrite.owriteLine(Data.LOC + keyName, "");
		ReadWrite.owriteLine(Data.LOC + keyName, enKey + "\n" + enPwCheck);
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
}
