package command;

import actions.*;
import resources.ReadWrite;

import java.io.IOException;

public class CryptCommand
{
	public static void main(String[] args) throws IOException
	{
		//bools
		boolean e = false;
		boolean d = false;
		boolean g = false;
		boolean r = false;
		boolean h = false;
		//seBool
		try
		{
			if(args[0].equals("/e"))
			{
				EncryptDecryptFile.encryptFile(args[1], args[2], args[3]);
			}
			else if(args[0].equals("/d"))
			{
				EncryptDecryptFile.decryptFile(args[1], args[2], args[3]);
			}
			else if(args[0].equals("/g"))
			{
				EditKey.genKey(args[1], args[2], Integer.parseInt(args[3]));
			}
			else if(args[0].equals("/r"))
			{
				EditKey.remKey(args[1]);
			}
			else if(args[0].equals("/?") || args[0].equals("/h"))
			{
				Help.help();
			}
			else 
			{
				args[999] = "";
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			System.out.println("Invalid Paramaters\nTry with /?");
		}
	}
}
