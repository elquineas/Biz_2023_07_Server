USE BOOKDB;

CREATE TABLE tbl_books(
	B_CODE		varchar(6)		PRIMARY KEY,
	B_NAME		varchar(125)	NOT NULL,
	B_AUTHER	varchar(125)	NOT NULL,	
	B_COMP		varchar(125),
	B_YEAR		int				NOT NULL,
	B_IPRICE	int,
	B_RPRICE	int				NOT NULL
);
CREATE TABLE tbl_users(
	U_CODE	varchar(6)		PRIMARY KEY,
	U_NAME	varchar(125)	NOT NULL,
	U_TEL	varchar(125),
	U_ADDR	varchar(125)		
);
CREATE TABLE tbl_rent_book(
	RENT_SEQ			bigint		PRIMARY KEY AUTO_INCREMENT,
	RENT_DATE			varchar(30)	NOT NULL,	
	RENT_RETURN_DATE	varchar(10)	NOT NULL,	
	RENT_BCODE			varchar(6)	NOT NULL,	
	RENT_UCODE			varchar(6)	NOT NULL,
	RENT_RETUR_YN		varchar(1),
	RENT_POINT			int		
);


-- FK 설정
ALTER TABLE tbl_rent_book
ADD CONSTRAINT fk_books
FOREIGN KEY (RENT_BCODE)
REFERENCES tbl_books(B_CODE)
ON DELETE CASCADE;

ALTER TABLE tbl_rent_book
ADD CONSTRAINT fk_users
FOREIGN KEY (RENT_UCODE)
REFERENCES tbl_users(U_CODE);


-- 도서코드	문자열(6)	B_CODE
-- 도서명	문자열(125)	B_NAME
-- 저자	문자열(125)	B_AUTHER
-- 출판사	문자열(125)	B_COMP
-- 구입연도	숫자	B_YEAR
-- 구입가격	숫자	B_IPRICE
-- 대여가격	숫자	B_RPRICE

INSERT INTO tbl_books(
	B_CODE,
	B_NAME,
	B_AUTHER,
	B_COMP,
	B_YEAR,
	B_IPRICE,
	B_RPRICE )
VALUES('','','','','','','')


























