@ECHO off
TITLE Crypt Installer
CHDIR "C:\Users\Program Files"

::MakeSource
ECHO Making Source...
MKDIR Crypt
CD Crypt
MKDIR bin
MKDIR keys
CACLS "%CD%\keys" /g Users:F

::MoveToSource
ECHO Enter Crypt.exe location
SET /p "LOC="
ECHO Moving Crypt.exe...
MV "%LOC%" "%CD%\bin"

::SetEnvVar
ECHO Setting Enviroment Variables...
SETX "CRYPT_KEYS" %CD%\keys /m
SETX "PATH" "%PATH%;%CD%\bin" /m

::END
ECHO Install complete
PAUSE>NUL
EXIT
