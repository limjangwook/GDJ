-- 테이블 삭제
DROP TABLE CUSTOMER;
DROP TABLE BANK;

-- 테이블 생성
CREATE TABLE BANK(
    BANK_CODE VARCHAR2(20 BYTE) NOT NULL,
    BANK_NAME VARCHAR2(30 BYTE) NOT NULL
);
    
-- 테이블 생성
CREATE TABLE CUSTOMER(
    NO        NUMBER            NOT NULL,
    NAME      VARCHAR2(30 BYTE) NOT NULL,
    PHONE     VARCHAR2(30 BYTE) UNIQUE,
    AGE       NUMBER            CHECK(AGE BETWEEN 0 AND 100),
    BANK_CODE VARCHAR2(20 BYTE)
);

-- 기본키 추가
ALTER TABLE BANK
    ADD CONSTRAINT PK_BANK PRIMARY KEY(BANK_CODE);
ALTER TABLE CUSTOMER
    ADD CONSTRAINT PK_CUSTOMER PRIMARY KEY(NO);

-- 외래키 추가
ALTER TABLE CUSTOMER
    ADD CONSTRAINT FK_CUSTOMER_BANK FOREIGN KEY (BANK_CODE)
        REFERENCES BANK(BANK_CODE)
            ON DELETE CASCADE;
            
-- 테이블 변경하기 (ALTER TABLE)
-- 1. 칼럼 추가   : ALTER TABLE 테이블 ADD 칼럼명 데이터타입 [제약조건]
-- 2. 칼럼 수정   : ALTER TABLE 테이블 MODIFY 칼럼명 데이터타입 [제약조건]
-- 3. 칼럼 삭제   : ALTER TABLE 테이블 DROP COLUMN 칼럼명
-- 4. 칼럼 이름   : ALTER TABLE 테이블 RENAME COLUMN OLD이름 TO NEW NAME이름
-- 5. 테이블 이름 : ALTER TABLE 테이블 RENAME TO NEW이름

-- 1. BANK 테이블에 BANK_PHONE 칼럼을 추가하시요.
ALTER TABLE BANK
    ADD BANK_PHONE VARCHAR2(20 BYTE) NULL;
    
-- 2. CUTOMER 테이블에 GRADE 칼럼을 추가하시오. ('VIP', 'GOLD', 'SILVER' 중 하나의 값만 가진다.)
ALTER TABLE CUSTOMER
    ADD GRADE VARCHAR2(6 BYTE) CHECK(GRADE IN('VIP', 'GOLD', 'SILVER'));

-- 3. BANK 테이블의 BANK_NAME 칼럼을 VARCHAR2(15 BYTE)로 수정하시오.
ALTER TABLE BANK
    MODIFY BANK_NAME VARCHAR2(15 BYTE);

--4. BANK 테이블의 BANK_NAME 칼럼을 NULL로 수정하시오.
ALTER TABLE BANK
    MODIFY BANK_NAME VARCHAR2(15 BYTE) NULL;
    
-- 5. CUSTOMER 테이블의 AGE 칼럼을 삭제하시오.
ALTER TABLE CUSTOMER
    DROP COLUMN AGE;

-- 6. CUSTOMER 테이블의 NO 칼럼과 NAME 칼럼이름을 CUST_NO와 CUST_NAME으로 수정하시오.
ALTER TABLE CUSTOMER
    RENAME COLUMN NO TO CUST_NO;
ALTER TABLE CUSTOMER
    RENAME COLUMN NAME TO CUST_NAME;
    
-- 7. BANK 테이블의 이름을 BANK_TBL로 수정하시오.
ALTER TABLE BANK
    RENAME TO BANK_TBL;