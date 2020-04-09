package command;

import actions.*;
import java.io.IOException;

public class CryptCommand
{
	public static void main(String[] args) throws IOException
	{
		String[] arg = new String[] {"/g", "TestKey.txt", "password", "64"};
		//String[] arg = new String[] {"/e", "Test.txt", "Testkey.txt", "password"};
		//bools
		boolean e = false;
		boolean d = false;
		boolean g = false;
		boolean r = false;
		boolean h = false;
		//seBool
		//try
		//{
			if(arg[0].equals("/e"))
			{
				EncryptDecryptFile.encryptFile(arg[1], arg[2], arg[3]);
			}
			else if(arg[0].equals("/d"))
			{
				EncryptDecryptFile.decryptFile(arg[1], arg[2], arg[3]);
			}
			else if(arg[0].equals("/g"))
			{
				EditKey.genKey(arg[1], arg[2], Integer.parseInt(arg[3]));
			}
			else if(arg[0].equals("/r"))
			{
				EditKey.remKey(arg[1]);
			}
			else if(arg[0].equals("/?") || arg[0].equals("/h"))
			{
				Help.help();
			}
		//}
		//catch(Exception ArrayIndexOutOfBoundsException)
		//{
		//	System.out.println("Invalid Paramaters\nTry with /?");
		//}
	}
}
