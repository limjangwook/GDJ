DROP SEQUENCE BOARD_SEQ;
CREATE SEQUENCE BOARD_SEQ NOCACHE;

DROP TABLE BOARD;
CREATE TABLE BOARD(
    BOARD_NO    NUMBER 			   NOT NULL,
    NAME		VARCHAR2(100 BYTE) NOT NULL,
    TITLE       VARCHAR2(100 BYTE) NOT NULL,
    CONTENT     VARCHAR2(400 BYTE),
    CREATE_DATE DATE,
    CONSTRAINT PK_BOARD PRIMARY KEY(BOARD_NO)
);

INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, '크롱', '공지', '불났다', SYSDATE);
COMMIT;