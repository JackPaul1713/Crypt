package actions;

import java.io.IOException;

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
		//genKey
		int[] biteKey = genByteKey(size);
		String key = EncryptDecrypt.encryptKey(biteKey, pw);
		//genPwCheck
		String pwCheck = Converstions.getStr(EncryptDecrypt.encryptBin(genBitePwCheck(pw), biteKey));
		//genFile
		FileMakeDelete.makeFile(Data.LOC + name);
		ReadWrite.owriteLine(Data.LOC + name, key + "\n" + pwCheck);
	}
	public static void remKey(String name) throws IOException
	{
		//wipe
		ReadWrite.owriteLine(Data.LOC + name, "");
		//rem
		FileMakeDelete.delFile(Data.LOC + name);
	}
	
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
			biteKey[i] = (int) (Math.random() * 255 + 1);
		}
		//ret
		return(biteKey);
	}
	private static int[] genBitePwCheck(String pw)
	{
		int[] bites = bufferBytes(getBytes(pw));
		return(bites);
	}
	
	//resources
	private static int[] getBytes(String str)
	{
		//var
		byte[] bites = str.getBytes();
		int[] intBites = new int[bites.length];
		//convert
		for(int i = 0; i < bites.length; i++)
		{
			intBites[i] = bites[i] & 0xFF;
		}
		return(intBites);
	}
	private static int[] bufferBytes(int[] bites)
	{
		//var
		int prev = (int) (Math.random() * 21);
		int post = (int) (Math.random() * 21);
		int[] bufBites = new int[prev + bites.length + post];
		//fillPrev
		for(int i = 0; i < prev; i++)
		{
			bufBites[i] = (int) (Math.random() * 255 + 1);
		}
		//fillBites
		for(int i = 0; i < bites.length; i++)
		{
			bufBites[i + prev] = bites[i];
		}
		//fillPost
		for(int i = 0; i < post; i++)
		{
			bufBites[i + prev + bites.length] = (int) (Math.random() * 255 + 1);
		}
		//ret
		return(bufBites);
	}
}
