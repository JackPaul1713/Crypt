# Crypt
Command line extension for encrypting and decrypting files

## Description
Crypt is a command line extention for encrypting and decrypting files. 

It uses a system involving a key and password.

## Installation

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
