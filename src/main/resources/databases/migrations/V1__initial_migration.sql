CREATE TABLE user (
  id         BIGINT(20) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR (255),
  last_name  VARCHAR (255),
  PRIMARY KEY (id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8;