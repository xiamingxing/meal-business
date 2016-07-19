@echo on
color 2f
mode con: cols=80 lines=25
@REM
@echo Deleting all .svn, please wait......
@rem Delete .svn in current and sub directories
@rem for /r . %%a in (.) do @if exist "%%a\.svn" @echo "%%a\.svn"
@for /r . %%a in (.) do @if exist "%%a\.svn" rd /s /q "%%a\.svn"
@echo SUCCESS!!!
@pause