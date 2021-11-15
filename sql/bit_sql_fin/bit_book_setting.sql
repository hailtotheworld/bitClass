/*  
    mini project DB자바라
    
    테이블생성  관련된 SQL문
    
    eXERD 수정사항
    1.  table 이름 변경   21/11/10
            book       -> bit_book, 
            order      -> bit_orders,
            order_log  -> bit_orders_log
            user       -> bit_users

*/


/* 카테고리 */
----------------------- 카테고리 시작 ----------------------------------------
-- DROP TABLE category CASCADE CONSTRAINTS;
-- DROP INDEX PK_category;
/* 카테고리 */
CREATE TABLE category (
	categoryid NUMBER(8) NOT NULL, /* 카테고리고유번호 */
	categoryname varchar2(40) NOT NULL /* 카테고리이름 */
);

COMMENT ON TABLE category IS '카테고리';

COMMENT ON COLUMN category.categoryid IS '카테고리고유번호';

COMMENT ON COLUMN category.categoryname IS '카테고리이름';

CREATE UNIQUE INDEX PK_category
	ON category (
		categoryid ASC
	);

ALTER TABLE category
	ADD
		CONSTRAINT PK_category
		PRIMARY KEY (
			categoryid
		);
        
------------------------ Category 끝 -------------------------------------


------------------------ Book 시작 ----------------------------------------


/* 책 */

--DROP INDEX PK_bit_book;
--DROP TABLE bit_book CASCADE CONSTRAINTS;

/* 책 */
CREATE TABLE bit_book (
	bookid NUMBER(8) NOT NULL, /* 책고유번호 */
	bookname VARCHAR2(40) NOT NULL, /* 책이름 */
	price NUMBER(10) NOT NULL, /* 책가격 */
	writer VARCHAR2(40) NOT NULL, /* 저자 */
	publisher VARCHAR2(40) NOT NULL, /* 출판사 */
	categoryid NUMBER(8), /* 카테고리고유번호 */
	stock NUMBER(1) DEFAULT 0 NOT NULL /* 재고 */
);

COMMENT ON TABLE bit_book IS '책';

COMMENT ON COLUMN bit_book.bookid IS '책고유번호';

COMMENT ON COLUMN bit_book.bookname IS '책이름';

COMMENT ON COLUMN bit_book.price IS '책가격';

COMMENT ON COLUMN bit_book.writer IS '저자';

COMMENT ON COLUMN bit_book.publisher IS '출판사';

COMMENT ON COLUMN bit_book.categoryid IS '카테고리고유번호';

COMMENT ON COLUMN bit_book.stock IS '재고';

CREATE UNIQUE INDEX PK_bit_book
	ON bit_book (
		bookid ASC
	);

ALTER TABLE bit_book
	ADD
		CONSTRAINT PK_bit_book
		PRIMARY KEY (
			bookid
		);

ALTER TABLE bit_book
	ADD
		CONSTRAINT FK_category_TO_bit_book
		FOREIGN KEY (
			categoryid
		)
		REFERENCES category (
			categoryid
		);

---------------------------- 주문로그 테이블 ------------------------------


/* 주문로그 */
-- DROP INDEX PK_bit_orders_log;
-- DROP TABLE bit_orders_log CASCADE CONSTRAINTS;

/* 주문로그 */
CREATE TABLE bit_orders_log (
	orderid_l NUMBER(8) NOT NULL, /* 주문로그번호 */
	orderid NUMBER(8) NOT NULL /* 주문고유번호 */
);

COMMENT ON TABLE bit_orders_log IS '주문로그';

COMMENT ON COLUMN bit_orders_log.orderid_l IS '주문로그번호';

COMMENT ON COLUMN bit_orders_log.orderid IS '주문고유번호';

CREATE UNIQUE INDEX PK_bit_orders_log
	ON bit_orders_log (
		orderid_l ASC,
		orderid ASC
	);

ALTER TABLE bit_orders_log
	ADD
		CONSTRAINT PK_bit_orders_log
		PRIMARY KEY (
			orderid_l,
			orderid
		);

        
------------------------------ 주문로그 테이블 -------------------------------

------------------------------- 주문 테이블 ---------------------------------


/* 주문 */
--DROP INDEX PK_bit_orders;
--DROP TABLE bit_orders CASCADE CONSTRAINTS;

/* 주문 */
CREATE TABLE bit_orders (
	orderid NUMBER(8) NOT NULL, /* 주문고유번호 */
	bookid NUMBER(8), /* 책고유번호 */
	userid NUMBER(2), /* 유저고유번호 */
	orderdate TIMESTAMP /* 주문일 */
);

COMMENT ON TABLE bit_orders IS '주문';

COMMENT ON COLUMN bit_orders.orderid IS '주문고유번호';

COMMENT ON COLUMN bit_orders.bookid IS '책고유번호';

COMMENT ON COLUMN bit_orders.userid IS '유저고유번호';

COMMENT ON COLUMN bit_orders.orderdate IS '주문일';

CREATE UNIQUE INDEX PK_bit_orders
	ON bit_orders (
		orderid ASC
	);

ALTER TABLE bit_orders
	ADD
		CONSTRAINT PK_bit_orders
		PRIMARY KEY (
			orderid
		);

ALTER TABLE bit_orders
	ADD
		CONSTRAINT FK_bit_book_TO_bit_orders
		FOREIGN KEY (
			bookid
		)
		REFERENCES bit_book (
			bookid
		);

----------------------------------------------------------------------------
--------------------- 유저테이블---------------------------------------------

/* 유저 */

--DROP INDEX PK_bit_users;
--DROP TABLE bit_users CASCADE CONSTRAINTS;

/* 유저 */
CREATE TABLE bit_users (
	userid NUMBER(2) NOT NULL, /* 유저고유번호 */
	username VARCHAR2(20) NOT NULL, /* 아이디 */
	password VARCHAR2(20) NOT NULL, /* 비밀번호 */
	name VARCHAR2(20) NOT NULL, /* 이름 */
	email VARCHAR2(40), /* 이메일 */
	phnum VARCHAR2(40), /* 전화번호 */
	address VARCHAR2(80) /* 주소 */
);

COMMENT ON TABLE bit_users IS '유저';

COMMENT ON COLUMN bit_users.userid IS '유저고유번호';

COMMENT ON COLUMN bit_users.username IS '아이디';

COMMENT ON COLUMN bit_users.password IS '비밀번호';

COMMENT ON COLUMN bit_users.name IS '이름';

COMMENT ON COLUMN bit_users.email IS '이메일';

COMMENT ON COLUMN bit_users.phnum IS '전화번호';

COMMENT ON COLUMN bit_users.address IS '주소';

CREATE UNIQUE INDEX PK_bit_users
	ON bit_users (
		userid ASC
	);

ALTER TABLE bit_users
	ADD
		CONSTRAINT PK_bit_users
		PRIMARY KEY (
			userid
		);
---------------
ALTER TABLE bit_orders_log
	ADD
		CONSTRAINT FK_bit_orders_TO_log
		FOREIGN KEY (
			orderid
		)
		REFERENCES bit_orders (
			orderid
		);
        

ALTER TABLE bit_orders
	ADD
		CONSTRAINT FK_bit_users_TO_bit_orders
		FOREIGN KEY (
			userid
		)
		REFERENCES bit_users (
			userid
		);
        