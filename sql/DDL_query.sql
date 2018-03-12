update category set post_count=2 where no = 1;

select * from category;

-- 블로그
ALTER TABLE `blog`
	DROP FOREIGN KEY `FK_user_TO_blog`; -- 회원 -> 블로그

-- 포스트
ALTER TABLE `post`
	DROP FOREIGN KEY `FK_blog_TO_post`; -- 블로그 -> 포스트

-- 포스트
ALTER TABLE `post`
	DROP FOREIGN KEY `FK_category_TO_post`; -- 카테고리 -> 포스트

-- 댓글
ALTER TABLE `comment`
	DROP FOREIGN KEY `FK_post_TO_comment`; -- 포스트 -> 댓글

-- 회원
DROP TABLE IF EXISTS `user` RESTRICT;

-- 블로그
DROP TABLE IF EXISTS `blog` RESTRICT;

-- 카테고리
DROP TABLE IF EXISTS `category` RESTRICT;

-- 포스트
DROP TABLE IF EXISTS `post` RESTRICT;

-- 댓글
DROP TABLE IF EXISTS `comment` RESTRICT;

-- 회원
CREATE TABLE `user` (
	`id`       VARCHAR(50) NOT NULL, -- 아이디
	`name`     VARCHAR(50) NOT NULL, -- 이름
	`password` VARCHAR(64) NOT NULL  -- 패스워드
);

-- 회원
ALTER TABLE `user`
	ADD CONSTRAINT `PK_user` -- 회원 기본키
		PRIMARY KEY (
			`id` -- 아이디
		);

-- 블로그
CREATE TABLE `blog` (
	`user_id` VARCHAR(50)  NOT NULL, -- 회원아이디
	`title`   VARCHAR(100) NOT NULL, -- 제목
	`image`   VARCHAR(100) NULL      -- 이미지
);

-- 블로그
ALTER TABLE `blog`
	ADD CONSTRAINT `PK_blog` -- 블로그 기본키
		PRIMARY KEY (
			`user_id` -- 회원아이디
		);

-- 카테고리
CREATE TABLE `category` (
	`no`          INTEGER      NOT NULL, -- 번호
	`name`        VARCHAR(50)  NOT NULL, -- 이름
	`description` VARCHAR(256) NULL,     -- 설명
	`post_count`  INTEGER      NOT NULL  -- 포스트수
);

-- 카테고리
ALTER TABLE `category`
	ADD CONSTRAINT `PK_category` -- 카테고리 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `category`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT;

-- 포스트
CREATE TABLE `post` (
	`no`          INTEGER       NOT NULL, -- 번호
	`user_id`     VARCHAR(50)   NOT NULL, -- 회원아이디
	`category_no` INTEGER       NOT NULL, -- 카테고리번호
	`title`       VARCHAR(100)  NOT NULL, -- 제목
	`body`        VARCHAR(1024) NULL      -- 내용
);

-- 포스트
ALTER TABLE `post`
	ADD CONSTRAINT `PK_post` -- 포스트 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `post`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT;

-- 댓글
CREATE TABLE `comment` (
	`no`      INTEGER      NOT NULL, -- 번호
	`body`    VARCHAR(256) NOT NULL, -- 내용
	`post_no` INTEGER      NOT NULL  -- 포스트번호
);

-- 댓글
ALTER TABLE `comment`
	ADD CONSTRAINT `PK_comment` -- 댓글 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `comment`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT;

-- 블로그
ALTER TABLE `blog`
	ADD CONSTRAINT `FK_user_TO_blog` -- 회원 -> 블로그
		FOREIGN KEY (
			`user_id` -- 회원아이디
		)
		REFERENCES `user` ( -- 회원
			`id` -- 아이디
		);

-- 포스트
ALTER TABLE `post`
	ADD CONSTRAINT `FK_blog_TO_post` -- 블로그 -> 포스트
		FOREIGN KEY (
			`user_id` -- 회원아이디
		)
		REFERENCES `blog` ( -- 블로그
			`user_id` -- 회원아이디
		);

-- 포스트
ALTER TABLE `post`
	ADD CONSTRAINT `FK_category_TO_post` -- 카테고리 -> 포스트
		FOREIGN KEY (
			`category_no` -- 카테고리번호
		)
		REFERENCES `category` ( -- 카테고리
			`no` -- 번호
		);

-- 댓글
ALTER TABLE `comment`
	ADD CONSTRAINT `FK_post_TO_comment` -- 포스트 -> 댓글
		FOREIGN KEY (
			`post_no` -- 포스트번호
		)
		REFERENCES `post` ( -- 포스트
			`no` -- 번호
		);