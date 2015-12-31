
## Create this below table if you want to generate report summary for all test suites you executed
## you need to turn on the REPORT_SUMMARY=on switch to make this option to work in config.properties file 

#Also make sure taht you change the
#REPORT_DB=<db tag where you created this table and configured in db_<env>.xml Ex: db_demo.xml>


CREATE TABLE "QA_AUTOMATION_SUMMARY" 
   (	"SUITE" VARCHAR2(200), 
	"RELEASE" VARCHAR2(10), 
	"RUNDATE" DATE, 
	"TESTCOUNT" NUMBER, 
	"PASSCOUNT" NUMBER, 
	"FAILCOUNT" NUMBER, 
	"PCTPASS" NUMBER(5,2), 
	"PCTFAIL" NUMBER(5,2), 
	"RUNBY" VARCHAR2(100) NOT NULL ENABLE, 
	"ENV" VARCHAR2(10), 
	 CONSTRAINT "PK1" PRIMARY KEY ("SUITE", "RUNDATE", "ENV"));
	 
## Create this table if you like to
	 
 create table test(
 apiname varchar primary key,
 basepath varchar,
 description varchar,
 endpoint varchar,
 urlview varchar,
 nameview varchar,
 viewdesc varchar);
 
 

order_no,created_dtm,current_status
begin batch

delete from test

INSERT into TEST (apiname,basepath ,description ,endpoint ,urlview ,nameview ,viewdesc ) values ( 'mytest1','/v1/weather','Testing Weather','http://weather.yahooapis.com','/myweather','myforcast','Weather forcast Milpitas')

INSERT into TEST (apiname,basepath ,description ,endpoint ,urlview ,nameview ,viewdesc ) values ( 'mytest2','/v2/weather','Testing Weather','http://weather.yahooapis.com','/myweather2','myforcast2','Weather forcast Fremont')

INSERT into TEST (apiname,basepath ,description ,endpoint ,urlview ,nameview ,viewdesc ) values ( 'mytest3','/v3/weather','Testing Weather','http://weather.yahooapis.com','/myweather3','myforcast3','Weather forcast Santa Clara')

Apply Batch;


###This below table is optional if you want to create a table and use it in your test or want to execute sample test which is using this table name

 create table order_line(
 order_no integer primary key,
 created_dtm date,
 current_status varchar);