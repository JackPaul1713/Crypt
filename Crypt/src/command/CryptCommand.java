package command;

import actions.*;
import java.io.IOException;

public class CryptCommand
{
	public static void main(String[] args) throws IOException
	{
		try
		{
			if(args[0].equals("/e"))
			{
				EncryptFile.encryptFile(args[1], args[2], args[3]);
			}
			else if(args[0].equals("/d"))
			{
				DecryptFile.decryptFile(args[1], args[2], args[3]);
			}
			else if(args[0].equals("/g"))
			{
				GenKey.genKey(args[1], args[2], Integer.parseInt(args[3]));
			}
			else if(args[0].equals("/r"))
			{
				RemKey.remKey(args[1]);
			}
			else if(args[0].equals("/?") || args[0].equals("/h"))
			{
				Help.help();
			}
			else 
			{
				System.out.println("Invalid Paramaters\nTry with /?");
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			System.out.println("Try with /?");
		}
	}
}
