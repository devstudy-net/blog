CREATE TABLE category (
    id integer NOT NULL,
    name varchar(20) NOT NULL,
    url varchar(20) NOT NULL,
    articles integer DEFAULT 0 NOT NULL
)
WITH (oids = false);

CREATE TABLE article (
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

CREATE TABLE account (
    id bigint NOT NULL,
    email varchar(100) NOT NULL,
    name varchar(30) NOT NULL,
    avatar varchar(255),
    created timestamp(0) without time zone DEFAULT now() NOT NULL
)
WITH (oids = false);

CREATE TABLE comment (
    id bigint NOT NULL,
    id_account bigint NOT NULL,
    id_article bigint NOT NULL,
    content text NOT NULL,
    created timestamp(0) without time zone DEFAULT now() NOT NULL
)
WITH (oids = false);

CREATE SEQUENCE account_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

CREATE SEQUENCE comment_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

CREATE INDEX comment_idx ON comment USING btree (id_article);
CREATE INDEX article_idx ON article USING btree (id_category);
CREATE INDEX comment_idx1 ON comment USING btree (id_account);

ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey
    PRIMARY KEY (id);

ALTER TABLE ONLY category
    ADD CONSTRAINT category_url_key
    UNIQUE (url);

ALTER TABLE ONLY article
    ADD CONSTRAINT article_pkey
    PRIMARY KEY (id);

ALTER TABLE ONLY account
    ADD CONSTRAINT account_pkey
    PRIMARY KEY (id);

ALTER TABLE ONLY account
    ADD CONSTRAINT account_email_key
    UNIQUE (email);

ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_pkey
    PRIMARY KEY (id);

ALTER TABLE ONLY article
    ADD CONSTRAINT article_fk
    FOREIGN KEY (id_category) REFERENCES category(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_fk
    FOREIGN KEY (id_account) REFERENCES account(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_fk1
    FOREIGN KEY (id_article) REFERENCES article(id) ON UPDATE CASCADE ON DELETE RESTRICT;

SELECT setval('account_seq', 1, false);
SELECT setval('comment_seq', 1, false);