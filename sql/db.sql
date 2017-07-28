DROP DATABASE IF EXISTS db_url;
CREATE DATABASE db_url;

DROP TABLE IF EXISTS db_url.mapper;
CREATE TABLE db_url.mapper (
  id       BIGINT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  original TEXT         NOT NULL
  COMMENT '原链',
  creation VARCHAR(191) NOT NULL UNIQUE
  COMMENT '短链'
)
  COMMENT '原链-短链 映射表';

TRUNCATE TABLE db_url.mapper;

SELECT *
FROM db_url.mapper;