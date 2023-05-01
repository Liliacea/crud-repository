create schema people;
create table people.newtable1 (
                                  id INT  PRIMARY KEY     NOT NULL GENERATED ALWAYS AS IDENTITY,
                                  surname text,
                                  name text,
                                  dateOfBirth timestamp without time zone);