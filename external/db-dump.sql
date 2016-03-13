-- SQL Manager Lite for PostgreSQL 5.6.2.46690
-- ---------------------------------------
-- Host      : localhost
-- Database  : blog
-- Version   : PostgreSQL 9.5.1, compiled by Visual C++ build 1800, 64-bit



SET check_function_bodies = false;
--
-- Structure for table category (OID = 16496) : 
--
SET search_path = public, pg_catalog;
CREATE TABLE public.category (
    id integer NOT NULL,
    name varchar(20) NOT NULL,
    url varchar(20) NOT NULL,
    articles integer DEFAULT 0 NOT NULL
)
WITH (oids = false);
--
-- Structure for table article (OID = 16504) : 
--
CREATE TABLE public.article (
    id bigint NOT NULL,
    title varchar(255) NOT NULL,
    url varchar(255) NOT NULL,
    logo varchar(255) NOT NULL,
    "desc" varchar(255) NOT NULL,
    content text NOT NULL,
    id_category integer NOT NULL,
    created timestamp(0) without time zone DEFAULT now() NOT NULL,
    views bigint DEFAULT 0 NOT NULL,
    comments integer DEFAULT 0 NOT NULL
)
WITH (oids = false);
--
-- Structure for table account (OID = 16515) : 
--
CREATE TABLE public.account (
    id bigint NOT NULL,
    email varchar(100) NOT NULL,
    name varchar(30) NOT NULL,
    avatar varchar(255),
    created timestamp(0) without time zone DEFAULT now() NOT NULL
)
WITH (oids = false);
--
-- Structure for table comment (OID = 16523) : 
--
CREATE TABLE public.comment (
    id bigint NOT NULL,
    id_account bigint NOT NULL,
    id_article bigint NOT NULL,
    content text NOT NULL,
    created timestamp(0) without time zone DEFAULT now() NOT NULL
)
WITH (oids = false);
--
-- Definition for sequence account_seq (OID = 16532) : 
--
CREATE SEQUENCE public.account_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence comment_seq (OID = 16534) : 
--
CREATE SEQUENCE public.comment_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for index comment_idx (OID = 16551) : 
--
CREATE INDEX comment_idx ON comment USING btree (id_article);
--
-- Definition for index article_idx (OID = 16552) : 
--
CREATE INDEX article_idx ON article USING btree (id_category);
--
-- Definition for index comment_idx1 (OID = 16553) : 
--
CREATE INDEX comment_idx1 ON comment USING btree (id_account);
--
-- Definition for index category_pkey (OID = 16500) : 
--
ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey
    PRIMARY KEY (id);
--
-- Definition for index category_url_key (OID = 16502) : 
--
ALTER TABLE ONLY category
    ADD CONSTRAINT category_url_key
    UNIQUE (url);
--
-- Definition for index article_pkey (OID = 16513) : 
--
ALTER TABLE ONLY article
    ADD CONSTRAINT article_pkey
    PRIMARY KEY (id);
--
-- Definition for index account_pkey (OID = 16519) : 
--
ALTER TABLE ONLY account
    ADD CONSTRAINT account_pkey
    PRIMARY KEY (id);
--
-- Definition for index account_email_key (OID = 16521) : 
--
ALTER TABLE ONLY account
    ADD CONSTRAINT account_email_key
    UNIQUE (email);
--
-- Definition for index comment_pkey (OID = 16530) : 
--
ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_pkey
    PRIMARY KEY (id);
--
-- Definition for index article_fk (OID = 16536) : 
--
ALTER TABLE ONLY article
    ADD CONSTRAINT article_fk
    FOREIGN KEY (id_category) REFERENCES category(id) ON UPDATE CASCADE ON DELETE RESTRICT;
--
-- Definition for index comment_fk (OID = 16541) : 
--
ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_fk
    FOREIGN KEY (id_account) REFERENCES account(id) ON UPDATE CASCADE ON DELETE RESTRICT;
--
-- Definition for index comment_fk1 (OID = 16546) : 
--
ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_fk1
    FOREIGN KEY (id_article) REFERENCES article(id) ON UPDATE CASCADE ON DELETE RESTRICT;
--
-- Data for sequence public.account_seq (OID = 16532)
--
SELECT pg_catalog.setval('account_seq', 1, false);
--
-- Data for sequence public.comment_seq (OID = 16534)
--
SELECT pg_catalog.setval('comment_seq', 1, false);
--
-- Comments
--
COMMENT ON SCHEMA public IS 'standard public schema';
