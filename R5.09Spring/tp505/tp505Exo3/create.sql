CREATE TABLE AUTHOR (IDAUTHOR  SERIAL NOT NULL, EMAIL VARCHAR(255), FIRSTNAME VARCHAR(255), NAME VARCHAR(20), PRIMARY KEY (IDAUTHOR))
CREATE TABLE BOOK (LNO  SERIAL NOT NULL, CATEGORY VARCHAR(255), TITLE VARCHAR(255), ano INTEGER, PRIMARY KEY (LNO))
ALTER TABLE BOOK ADD CONSTRAINT FK_BOOK_ano FOREIGN KEY (ano) REFERENCES AUTHOR (IDAUTHOR)
