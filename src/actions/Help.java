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
		System.out.println("   /c - Changes key, crypt /c [name] {-n [newName], -p [oldPw] [newPw]}");
		System.out.println("   /l - Lists keys, crypt /l");
		System.out.println("   /? - Provides help, crypt /?");
	}
}
