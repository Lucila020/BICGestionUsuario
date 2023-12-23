CREATE TABLE PHONE (
    ID SERIAL PRIMARY KEY,
    NUMBER VARCHAR(20),
    CITY_CODE VARCHAR(20),
    COUNTRY_CODE VARCHAR(20),
    FK_USER VARCHAR(255) REFERENCES USER(ID)
);


CREATE TABLE USER (
    ID VARCHAR(255) NOT NULL,
    NAME VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
	PHONE_ID INT NOT NULL,
    CREATED_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    MODIFIED TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    LAST_LOGIN_DATE TIMESTAMP NOT NULL,
    TOKEN VARCHAR(255) NOT NULL,
    IS_ACTIVE BOOL NOT NULL DEFAULT true,
	CONSTRAINT USER_EMAIL_UK UNIQUE (EMAIL),
	CONSTRAINT USER_ID_PK PRIMARY KEY (ID),
	CONSTRAINT USER_PHONE_ID_FK FOREIGN KEY (PHONE_ID) REFERENCES PHONE(ID)
);