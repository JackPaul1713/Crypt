package command;

import actions.*;
import resources.ReadWrite;

import java.io.IOException;

public class CryptCommand
{
	public static void main(String[] args) throws IOException
	{
		String testPw = "!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\\\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>!@#$%^&*()qwertyuiopQWERTYUIOP{}ASDFGHJKL:\\\"ZXCVBNV<>";
		for (int i = 0; i < 1000; i++)
		{
			System.out.print("(" + (i+1) + ")");
			EditKey.genKey("SuperCoolTestKey", testPw, 12);
			EncryptDecryptFile.encryptFile("C:\\Users\\JackPaul\\Desktop\\Test.txt", "SuperCoolTestKey", testPw);
			//System.out.println(ReadWrite.readLine("C:\\Users\\JackPaul\\Desktop\\Test.txt"));
			EncryptDecryptFile.decryptFile("C:\\Users\\JackPaul\\Desktop\\Test.txt", "SuperCoolTestKey", testPw);
			//System.out.println(ReadWrite.readLine("C:\\Users\\JackPaul\\Desktop\\Test.txt"));
			if(ReadWrite.readLine("C:\\Users\\JackPaul\\Desktop\\Test.txt").equals("Hopefully this works."))
				System.out.println("true");
			else
				System.out.println("FALSE!!!");
			EditKey.remKey("SuperCoolTestKey");
			testPw = testPw.substring(1);
		}
		/*//bools
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
		}*/
	}
}
