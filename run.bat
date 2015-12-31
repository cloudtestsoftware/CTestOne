@echo off
REM #################################################
REM # TestMax execution wrapper for windwows.
REM #
REM # Date Created: Jan 05, 2015
REM # author: Srimanta
REM #
REM # Copyright (c) 2015 CloudTestSoftware.com
REM ##################################################
REM ====================Global initialization =================
REM enable delayed environment
setlocal ENABLEDELAYEDEXPANSION

set CTS_ROOT=.

REM ==================== Locate CTestOne executable =======================
REM echo Searching TestMax.jar ...
REM set APP=%CTS_ROOT%\lib\TestMax.jar
REM echo checking %APP%
REM if not exist %APP% echo Not found
REM if exist %APP% (
REM    echo CTestOne executable found: %APP%
REM    goto label_set_classpath
REM )
REM some IDE may use "dist\"
REM set APP=%CTS_ROOT%\dist\TestMax.jar
REM echo checking %APP% ...
REM if not exist %APP% (
REM    echo Not found again
REM    echo exit now!
REM    goto label_end
REM )
REM if exist %APP% echo CTestOne executable found: %APP%
REM echo.


REM =================== Set CLASSPATH ====================
REM set CLASSPATH
:label_set_classpath
set CLASSPATH=%CTS_ROOT%\build\classes;%CTS_ROOT%\lib\TestMax.jar;
for /r .\lib %%i in (*.jar) do set CLASSPATH=!CLASSPATH!;%%i
echo CLASSPATH=%CLASSPATH%
echo.


set CTestOne_CMD=java com.testmax.runner.TestRunner %*
echo Executing CloudTest by CMD: %CTestOne_CMD%
echo.
echo ------------------------------ CTestOne output ------------------------------
%CTestOne_CMD%

REM end
:label_end