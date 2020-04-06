package command;

import java.io.IOException;

import actions.*;
import resources.*;

public class CryptCommand
{
	public static void main(String[] args) throws IOException
	{
		String pw = "abc";
		GenKey.genKey("TestKey.txt", pw, 4);
		Encrypt.encryptFile("C:\\Users\\JackPaul\\Desktop\\Test.txt", "TestKey.txt", pw);
	}
}
