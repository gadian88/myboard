--------------------------------------------------------
--  督析戚 持失喫 - 塘推析-5杉-20-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AUTHORITY
--------------------------------------------------------

  CREATE TABLE "BOARD"."AUTHORITY" 
   (	"USERNAME" VARCHAR2(20 BYTE), 
	"AUTHORITY_NAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "BOARD" ;
--------------------------------------------------------
--  DDL for Table BOARD_PRO
--------------------------------------------------------

  CREATE TABLE "BOARD"."BOARD_PRO" 
   (	"BNO" NUMBER(*,0), 
	"SUBJECT" VARCHAR2(50 BYTE), 
	"CONTENT" VARCHAR2(1024 BYTE), 
	"WRITER" VARCHAR2(50 BYTE), 
	"REG_DATE" DATE, 
	"HIT" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "BOARD" ;
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "BOARD"."MEMBER" 
   (	"USERNAME" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(500 BYTE), 
	"NAME" VARCHAR2(20 BYTE), 
	"IS_ACCOUNT_NON_EXPIRED" VARCHAR2(1 BYTE), 
	"IS_ACCOUNT_NON_LOCKED" VARCHAR2(1 BYTE), 
	"IS_CREDENTIALS_NON_EXPIRED" VARCHAR2(1 BYTE), 
	"IS_ENABLED" VARCHAR2(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "BOARD" ;
REM INSERTING into BOARD.AUTHORITY
SET DEFINE OFF;
REM INSERTING into BOARD.BOARD_PRO
SET DEFINE OFF;
Insert into BOARD.BOARD_PRO (BNO,SUBJECT,CONTENT,WRITER,REG_DATE,HIT) values (9,'げ',null,'けいし',to_date('17/05/19','RR/MM/DD'),0);
Insert into BOARD.BOARD_PRO (BNO,SUBJECT,CONTENT,WRITER,REG_DATE,HIT) values (1,'けいし','鯵舜猿!!!!','けいし',to_date('17/05/19','RR/MM/DD'),2);
Insert into BOARD.BOARD_PRO (BNO,SUBJECT,CONTENT,WRITER,REG_DATE,HIT) values (4,'けいし','dasdasd','けいし',to_date('17/05/19','RR/MM/DD'),0);
Insert into BOARD.BOARD_PRO (BNO,SUBJECT,CONTENT,WRITER,REG_DATE,HIT) values (6,'佐重旭革','瞬!','傾硝',to_date('17/05/19','RR/MM/DD'),0);
Insert into BOARD.BOARD_PRO (BNO,SUBJECT,CONTENT,WRITER,REG_DATE,HIT) values (7,'織佐',null,'けいし',to_date('17/05/19','RR/MM/DD'),0);
REM INSERTING into BOARD.MEMBER
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index BOARD_PRO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOARD"."BOARD_PRO_PK" ON "BOARD"."BOARD_PRO" ("BNO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "BOARD" ;
--------------------------------------------------------
--  DDL for Index MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOARD"."MEMBER_PK" ON "BOARD"."MEMBER" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "BOARD" ;
--------------------------------------------------------
--  Constraints for Table AUTHORITY
--------------------------------------------------------

  ALTER TABLE "BOARD"."AUTHORITY" MODIFY ("AUTHORITY_NAME" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."AUTHORITY" MODIFY ("USERNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BOARD_PRO
--------------------------------------------------------

  ALTER TABLE "BOARD"."BOARD_PRO" ADD CONSTRAINT "BOARD_PRO_PK" PRIMARY KEY ("BNO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "BOARD"  ENABLE;
  ALTER TABLE "BOARD"."BOARD_PRO" MODIFY ("REG_DATE" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."BOARD_PRO" MODIFY ("WRITER" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."BOARD_PRO" MODIFY ("SUBJECT" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."BOARD_PRO" MODIFY ("BNO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "BOARD"."MEMBER" ADD CONSTRAINT "MEMBER_PK" PRIMARY KEY ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "BOARD"  ENABLE;
  ALTER TABLE "BOARD"."MEMBER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."MEMBER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "BOARD"."MEMBER" MODIFY ("USERNAME" NOT NULL ENABLE);
