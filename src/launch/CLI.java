package launch;

import actions.*;

import java.io.IOException;

public class CLI
{
	public static void main(String[] args) throws IOException
	{
		//runCommands
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
			else if(args[0].equals("/c"))
			{
				if(args[2].equals("-n"))
				{
					EditKey.changeName(args[1], args[3]);
				}
				else if(args[2].equals("-p"))
				{
					EditKey.changePw(args[1], args[3], args[4]);
				}
				else
				{
					args[999] = "";
				}
			}
			else if(args[0].equals("/l"))
			{
				EditKey.listKeys();
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
