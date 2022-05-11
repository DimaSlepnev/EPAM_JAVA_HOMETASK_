USE videoteka;
CREATE TABLE films(
                      Id INT PRIMARY KEY AUTO_INCREMENT,
                      Film_Name VARCHAR(25),
                      Date_Prodaction DATE,
                      Country VARCHAR(20)
);
INSERT INTO films VALUES(1,'Green mille', '1999-12-06', 'USA'),
                        (2,'1+1','2012-04-26','France'),
                        (3,'The Big Lebowski', '1998-03-06', 'USA'),
                        (4,'Tenet','2020-08-12','Great Britain'),
                        (5,'Inception','2010-07-22','USA');
CREATE TABLE actors(
                       Id INT PRIMARY KEY AUTO_INCREMENT,
                       FIO VARCHAR(50),
                       Birthdate DATE
);
INSERT INTO actors VALUES (1,'Tom Henks','1956-07-09'), (2, 'Michael Clarke Duncan','1957-12-10'),
                          (3,'Omar Sy','1978-01-20'), (4,'Francois Cluzet','1955-09-21'),
                          (5, 'Jeff Bridges', '1949-12-04'), (6, 'Steven Vincent Buscem', '1957-12-13'),
                          (7,'John David Washington','1984-07-28'), (8, 'Robert Douglas Thomas Pattinson', '1986-05-13'),
                          (9,'Leonardo Wilhelm DiCaprio', '1974-11-11'), (10, 'Elliot Page', '1987-02-21');
CREATE TABLE film_actors(
                            Film__Id int,
                            Actor_Id int
);
INSERT INTO film_actors VALUES(1,1), (1,2),(2,3),(2,4),(3,5),(3,6),(4,7),(4,8),(5,9),(5,10);
CREATE TABLE film_directors(
                               Film_ID int,
                               Actor_Id int
);
INSERT INTO film_directors VALUES(1,6),(2,5),(3,4),(4,6),(5,9);
UPDATE films SET Date_Prodaction = '2021-08-12' WHERE Date_Prodaction = '2020-08-12';
