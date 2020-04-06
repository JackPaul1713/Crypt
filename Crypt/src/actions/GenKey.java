package actions;

import java.io.IOException;

import resources.EncryptDecrypt;
import resources.FileMakeDelete;
import resources.ReadWrite;
import resources.Data;

public class GenKey
{
	//genKey
	public static void genKey(String name, String pw, int size) throws IOException
	{
		int[] biteKey = genByteKey(size);
		String key = EncryptDecrypt.encryptKey(biteKey, pw);
		FileMakeDelete.makeFile(Data.LOC + name);
		ReadWrite.owriteLine(Data.LOC + name, key);
	}
	
	//resources
	private static int[] genByteKey(int size)
	{
		//var
		int[] biteKey = new int[size];
		//generate
		for(int i = 0; i < size; i++)
		{
			biteKey[i] = (int) (Math.random() * 255 + 1);
		}
		//ret
		return(biteKey);
	}
}
