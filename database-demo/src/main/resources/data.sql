create table userInfo
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    mailId varchar(255),
    primary key(id)
);

INSERT INTO userInfo (ID,NAME ,LOCATION, mailId)
    VALUES('1', 'Gowtham Sankar', 'salem', 'gmsk@gmail.com');
INSERT INTO userInfo (ID,NAME ,LOCATION, mailId)
    VALUES('2', 'Jay Kumar', 'salem', 'jay@gmail.com');
INSERT INTO userInfo (ID,NAME ,LOCATION, mailId)
    VALUES('3', 'Manoj', 'salem', 'manoj@gmail.com');





