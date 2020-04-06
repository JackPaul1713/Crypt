package actions;

import java.io.IOException;

import resources.Data;
import resources.EncryptDecrypt;
import resources.ReadWrite;

public class EncryptFile
{
	public static void encryptFile(String path, String keyName, String pw) throws IOException
	{
		//var
		String enKey = ReadWrite.readLine(Data.LOC + keyName);
		int[] bites = ReadWrite.readBinFile(path);
		for(int b: bites)
		{
			System.out.print(b + " ");
		}
		System.out.println("\nOG Bytes^");
		int[] biteKey = EncryptDecrypt.decryptKey(enKey, pw);
		//encrypt
		bites = EncryptDecrypt.encryptBin(bites, biteKey);
		for(int b: bites)
		{
			System.out.print(b + " ");
		}
		System.out.println("\nEn Bytes^");
		ReadWrite.owriteLine(path, "");
		ReadWrite.writeBinFile(path, bites);
	}
}
