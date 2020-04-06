package actions;

import java.io.IOException;

import resources.Data;
import resources.EncryptDecrypt;
import resources.ReadWrite;

public class DecryptFile
{
	public static void decryptFile(String path, String keyName, String pw) throws IOException
	{
		//var
		String enKey = ReadWrite.readLine(Data.LOC + keyName);
		int[] bites = ReadWrite.readBinFile(path);
		int[] biteKey = EncryptDecrypt.decryptKey(enKey, pw);
		//encrypt
		bites = EncryptDecrypt.decryptBin(bites, biteKey);
		for(int b: bites)
		{
			System.out.print(b + " ");
		}
		System.out.println("\nDe Bytes^");
		ReadWrite.owriteLine(path, "");
		ReadWrite.writeBinFile(path, bites);
	}
}
