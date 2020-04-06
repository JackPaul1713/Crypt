package actions;

import java.io.IOException;

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
		int[] bites = ReadWrite.readBinFile(path);
		int[] biteKey = EncryptDecrypt.decryptKey(enKey, pw);
		//encrypt
		bites = EncryptDecrypt.encryptBin(bites, biteKey);
		ReadWrite.owriteLine(path, "");
		ReadWrite.writeBinFile(path, bites);
	}
	public static void decryptFile(String path, String keyName, String pw) throws IOException
	{
		//var
		path = setPath(path);
		String enKey = ReadWrite.readLine(Data.LOC + keyName);
		int[] bites = ReadWrite.readBinFile(path);
		int[] biteKey = EncryptDecrypt.decryptKey(enKey, pw);
		//encrypt
		bites = EncryptDecrypt.decryptBin(bites, biteKey);
		ReadWrite.owriteLine(path, "");
		ReadWrite.writeBinFile(path, bites);
	}
	
	//setPath
	private static String setPath(String path)
	{
		if(!path.contains("\\"))
		{
			path = "%CD%\\" + path;
		}
		return(path);
	}
}
