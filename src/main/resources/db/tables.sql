START TRANSACTION;

CREATE TABLE T_USR (
	USR_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	FST_NM VARCHAR(255) NOT NULL,
	LST_NM VARCHAR(255),
	EMAIL VARCHAR(255),
	CREATED_DT TIMESTAMP
);

CREATE TABLE T_TOPIC (
	TOPIC_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	TOPIC_TAG VARCHAR(25) NOT NULL,
	TOPIC_DS VARCHAR(255)
);

CREATE TABLE T_BLOG (
	BLOG_ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	AUTHOR_ID INT NOT NULL,
	LIKES INT DEFAULT 0,
	CONTENT TEXT,
	HEADING VARCHAR(255),
	CREATED_DT TIMESTAMP,
	UPDT_DT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FK_BLOG_USER FOREIGN KEY (AUTHOR_ID) REFERENCES T_USR(USR_ID)
);

CREATE TABLE T_USR_TOPIC (
	USR_ID INT NOT NULL,
	TOPIC_ID INT NOT NULL,
	CONSTRAINT FK_USR_TOPIC_USR FOREIGN KEY (USR_ID) REFERENCES T_USR(USR_ID),
	CONSTRAINT FK_USR_TOPIC_TOPIC FOREIGN KEY (TOPIC_ID) REFERENCES T_TOPIC(TOPIC_ID)
);

CREATE TABLE T_BLOG_TOPIC(
	BLOG_ID INT NOT NULL,
	TOPIC_ID INT NOT NULL,
	CONSTRAINT FK_BLOG_TOPIC_TOPIC FOREIGN KEY (TOPIC_ID) REFERENCES T_TOPIC(TOPIC_ID),
	CONSTRAINT FK_BLOG_TOPIC_BLOG FOREIGN KEY (BLOG_ID) REFERENCES T_BLOG(BLOG_ID)
);

DROP TABLE IF EXISTS T_CMNT;
CREATE TABLE T_CMNT(
	CMNT_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	CMNT VARCHAR(255) NOT NULL,
	USR_ID INT NOT NULL,
	BLOG_ID INT NOT NULL,
	CMNT_DT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FK_CMNT_USR FOREIGN KEY (USR_ID) REFERENCES T_USR(USR_ID),
	CONSTRAINT FK_CMNT_BLOG FOREIGN KEY (BLOG_ID) REFERENCES T_BLOG(BLOG_ID)
);

COMMIT;