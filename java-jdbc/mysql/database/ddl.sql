CREATE DATABASE IF NOT EXISTS commerce;

USE commerce;

-- DDL

CREATE TABLE IF NOT EXISTS product (
  id int(11) NOT NULL PRIMARY KEY,
  name varchar(255) NOT NULL,
  status char(1) DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
