package actions;

import java.io.IOException;

import resources.Data;
import resources.EncryptDecrypt;
import resources.ReadWrite;

public class Decrypt
{
	public static void decryptFile(String path, String keyName, String pw) throws IOException
	{
		//var
		String enKey = ReadWrite.readLine(Data.LOC + keyName);
		int[] bites = ReadWrite.readBinFile(path);
		int[] biteKey = EncryptDecrypt.decryptKey(enKey, pw);
		//encrypt
		bites = EncryptDecrypt.decryptBin(bites, biteKey);
		ReadWrite.writeBinFile(path, bites);
	}
}
