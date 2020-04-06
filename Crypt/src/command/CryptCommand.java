package command;

import actions.*;
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
				e = true;
			}
			else if(args[0].equals("/d"))
			{
				d = true;
			}
			else if(args[0].equals("/g"))
			{
				g = true;
			}
			else if(args[0].equals("/r"))
			{
				r = true;
			}
			else if(args[0].equals("/?") || args[0].equals("/h"))
			{
				h = true;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			System.out.println("Invalid Paramaters\nTry with /?");
		}
		//runWithErrors
		if(e)
		{
			EncryptDecryptFile.encryptFile(args[1], args[2], args[3]);
		}
		else if(d)
		{
			EncryptDecryptFile.decryptFile(args[1], args[2], args[3]);
		}
		else if(g)
		{
			EditKey.genKey(args[1], args[2], Integer.parseInt(args[3]));
		}
		else if(r)
		{
			EditKey.remKey(args[1]);
		}
		else if(h)
		{
			Help.help();
		}
	}
}
