DROP DATABASE IF EXISTS demo_dev;
DROP DATABASE IF EXISTS demo_test;

CREATE DATABASE demo_dev;
CREATE DATABASE demo_test;

CREATE USER IF NOT EXISTS 'demo'@'localhost'
  IDENTIFIED BY 'demo';
GRANT ALL PRIVILEGES ON demo_dev.* TO 'demo' @'localhost';
GRANT ALL PRIVILEGES ON demo_test.* TO 'demo' @'localhost';