
  CREATE TABLE "SYSTEM"."CONTACTUS" 
   (	"NAME" VARCHAR2(30 BYTE), 
	"PHNUMBER" NUMBER(12,0), 
	"CITY" VARCHAR2(25 BYTE), 
	"SUBJECT" VARCHAR2(250 BYTE), 
	"UPDATE_DATE" TIMESTAMP (6)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
