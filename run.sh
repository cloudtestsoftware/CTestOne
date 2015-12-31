#!/bin/bash

##################################################
# CTestOne execution wrapper for Linux.
#
# Date Created: June 06, 2015
# author: Srimanta Jana
#
# Copyright (c) 2015 CloudTestSoftware.com
##################################################
CTS_ROOT=.
export CTS_ROOT
# set working directory
cd $CTS_ROOT
echo Working directory: `pwd`
echo

# find TestMax.jar    #we run class directly now, not jar, so no need to locate it
#APP=""
#if [ -f ./build/TestMax.jar ]; then
#    APP=${CTS_ROOT}build/TestMax.jar
#    echo TestMax executable found: $APP
#elif [ -f ./dist/TestMax.jar ]; then
#    APP=${CTS_ROOT}dist/TestMax.jar
#    echo TestMax executable found: $APP
#else
#    echo CTS executable TestMax.jar not found!
#    exit 1    
#fi
#echo

# set CLASSPATH
unset CLASSPATH


CLASSPATH=${CTS_ROOT}/build/classes


for i in `ls -1R ${CTS_ROOT}lib/*.jar`
do
    CLASSPATH=$CLASSPATH:$i
done

export CLASSPATH   

echo CLASSPATH=$CLASSPATH


# execute TestMax
JWM_CMD="java com.testmax.runner.TestRunner $*"
echo Executing CTestOne by CMD: $JWM_CMD
echo
echo -------------------------------- CTestOne output --------------------------------
$JWM_CMD


