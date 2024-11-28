drop table student;

truncate table student;

create table student
(
    id serial constraint student_pk primary key,
    name text,
    dob int
);

create table groupp(
                       id serial constraint groupp_pk primary key,
                       name text,
                       start date
);
truncate groupp;
drop table groupp;
INSERT INTO groupp (name, start) VALUES ('FS1', '2023-03-01');
INSERT INTO groupp (name, start) VALUES ('FS2', '2023-04-01');
INSERT INTO groupp (name, start) VALUES ('FS3', '2023-05-01');
INSERT INTO groupp (name, start) VALUES ('FS4', '2023-06-01');
INSERT INTO groupp (name, start) VALUES ('FS5', '2023-07-01');
INSERT INTO groupp (name, start) VALUES ('FS6', '2023-08-01');
INSERT INTO groupp (name, start) VALUES ('FS7', '2023-09-01');
INSERT INTO groupp (name, start) VALUES ('FS8', '2024-05-09');

INSERT INTO student (name, dob, group_id) VALUES ('Jim', 1942, 1);
INSERT INTO student (name, dob, group_id) VALUES ('Jack', 1981, 2);
INSERT INTO student (name, dob, group_id) VALUES ('Mary', 2000, 3);
INSERT INTO student (name, dob, group_id) VALUES ('Helen', 2002, 5);
INSERT INTO student (name, dob, group_id) VALUES ('Nate', 2001, 5);
INSERT INTO student (name, dob, group_id) VALUES ('Jacky', 2002, 5);
INSERT INTO student (name, dob, group_id) VALUES ('Olha', 2011, null);
INSERT INTO student (name, dob, group_id) VALUES ('Alex', 1975, 6);
INSERT INTO student (name, dob, group_id) VALUES ('Alex', 1975, 4);
INSERT INTO student (name, dob, group_id) VALUES ('Tom', 2020, 7);
INSERT INTO student (name, dob, group_id) VALUES ('Bill', 2015, null);




insert into student (name, dob) values ('Jim', 1973);
insert into student (name, dob) values ('Alex', 1976);

select id, name, dob from student;

select name from student
where dob = 1973;

delete from student where id=4;

update student
set dob = 1975
where id = 3;

alter table student add column groupp text;

select * from student;
select * from student order by id;
select * from student order by name, dob;
select * from student order by name, dob DESC;
select * from student order by dob;

select id, name, dob, group_id from student;

select * from groupp;

select * from student, groupp;
select * from student, (select from student where false) as t1;

select s1.name, s2.name from student s1, student s2;

select s.name, g.name, g.start
from student s
         inner join groupp g on s.group_id = g.id
offset 2
    limit 2
;






select s.name, g.name, g.start
from student s
         left outer join groupp g on s.group_id = g.id;

select s.name, g.name, g.start
from student s
         right outer join groupp g on s.group_id = g.id;

select s.name, g.name, g.start
from student s
         full join groupp g on s.group_id = g.id;

select s.name, g.name, g.start
from student s
         cross join groupp g;














drop table student;

truncate table student;

create table student
(
    id serial constraint student_pk primary key,
    name text,
    dob int
);

create table groupp(
                       id serial constraint groupp_pk primary key,
                       name text,
                       start date
);
truncate groupp;
drop table groupp;
INSERT INTO groupp (name, start) VALUES ('FS1', '2023-03-01');
INSERT INTO groupp (name, start) VALUES ('FS2', '2023-04-01');
INSERT INTO groupp (name, start) VALUES ('FS3', '2023-05-01');
INSERT INTO groupp (name, start) VALUES ('FS4', '2023-06-01');
INSERT INTO groupp (name, start) VALUES ('FS5', '2023-07-01');
INSERT INTO groupp (name, start) VALUES ('FS6', '2023-08-01');
INSERT INTO groupp (name, start) VALUES ('FS7', '2023-09-01');
INSERT INTO groupp (name, start) VALUES ('FS8', '2024-05-09');

INSERT INTO student (name, dob, group_id) VALUES ('Jim', 1942, 1);
INSERT INTO student (name, dob, group_id) VALUES ('Jack', 1981, 2);
INSERT INTO student (name, dob, group_id) VALUES ('Mary', 2000, 3);
INSERT INTO student (name, dob, group_id) VALUES ('Helen', 2002, 5);
INSERT INTO student (name, dob, group_id) VALUES ('Nate', 2001, 5);
INSERT INTO student (name, dob, group_id) VALUES ('Jacky', 2002, 5);
INSERT INTO student (name, dob, group_id) VALUES ('Olha', 2011, null);
INSERT INTO student (name, dob, group_id) VALUES ('Alex', 1975, 6);
INSERT INTO student (name, dob, group_id) VALUES ('Alex', 1975, 4);
INSERT INTO student (name, dob, group_id) VALUES ('Tom', 2020, 7);
INSERT INTO student (name, dob, group_id) VALUES ('Bill', 2015, null);




insert into student (name, dob) values ('Jim', 1973);
insert into student (name, dob) values ('Alex', 1976);

select id, name, dob from student;

select name from student
where dob = 1973;

delete from student where id=4;

update student
set dob = 1975
where id = 3;

alter table student add column groupp text;

select * from student;
select * from student order by id;
select * from student order by name, dob;
select * from student order by name, dob DESC;
select * from student order by dob;

select id, name, dob, group_id from student;

select * from groupp;

select * from student, groupp;
select * from student, (select from student where false) as t1;

select s1.name, s2.name from student s1, student s2;

select s.name, g.name, g.start
from student s
         inner join groupp g on s.group_id = g.id
offset 2
    limit 2
;

select s.name, g.name, g.start
from student s
         left outer join groupp g on s.group_id = g.id;

select s.name, g.name, g.start
from student s
         right outer join groupp g on s.group_id = g.id;

select s.name, g.name, g.start
from student s
         full join groupp g on s.group_id = g.id;

select s.name, g.name, g.start
from student s
         cross join groupp g

