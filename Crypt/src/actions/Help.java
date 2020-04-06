package actions;

public class Help
{
	public static void help()
	{
		System.out.println("");
		System.out.println("The syntax of the command is as follows:");
		System.out.println("   Crypt [/action] {args[]}");
		System.out.println("   /e - Encrypts files, crypt /e [path] [keyName] [password]");
		System.out.println("   /d - Decrypts files, crypt /d [path] [keyName] [password]");
		System.out.println("   /g - Generates key, crypt /g [name] [password] [size]");
		System.out.println("   /r - Removes key, crypt /r [name]");
		//System.out.println("");
		//System.out.println("   *CRYPT_KEYS enviroment variable must be set*");
	}
}
