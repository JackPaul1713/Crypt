# Crypt
Command line extension for encrypting and decrypting files

## Description
Crypt is a command line extention for encrypting and decrypting files. 
It uses a very basic cypher and a symetric key, as well as a password. A password modified version of the key is stored localy. To use the key the password is used to decrypt the modified key. The key is then used with the basic cypher on the bytes from a file.

## Installation
Install Instructions:
1. Fork the Crypt repository
2. Export as a runnable jar file
3. Make an exe file with launch j4 useing the jar file
4. Run the install.bat file as an administrator

## Usage
Syntax:
```
Crypt [/action] {args[]}
/e - Encrypts files, crypt /e [path] [keyName] [password]
/d - Decrypts files, crypt /d [path] [keyName] [password]
/g - Generates key, crypt /g [name] [password] [size]
/r - Removes key, crypt /r [name]
/c - Changes key, crypt /c [name] {-n [newName], -p [oldPw] [newPw]}
/l - Lists keys, crypt /l
/? - Provides help, crypt /?
```
