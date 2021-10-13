create database springsecurity;
use springsecurity;

CREATE TABLE IF NOT EXISTS user (
    ID INT(10) NOT NULL AUTO_INCREMENT,
    ACTIVE INT(1),
    USER_NAME VARCHAR(128),
    PASS_WORD VARCHAR(128),
    ROLES VARCHAR(128),
    PRIMARY KEY (ID))
    ENGINE = InnoDB;

insert into springsecurity.user (ID, ACTIVE, USER_NAME, PASS_WORD, ROLES, password)
values  (1, 1, 'nbduc', '1', 'ROLE_USER,ROLE_ADMIN'),
        (2, 1, 'zac', '1', 'ROLE_USER');