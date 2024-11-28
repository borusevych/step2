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

-- x AND y
-- x OR y
-- NOT x
-- IS NULL
-- IS NOT NULL

select * from student
where group_id IS NOT NULL;

select * from student
where group_id = 3;

select * from student
where group_id >= 3;

select * from student
where name = 'Jim';

select * from student
where name like 'J%'; -- s.startsWith('J')

select * from student
where name like '%x'; -- s.endsWith('x')

select * from student
where name like '%L%'; -- s.contains('l')

select * from student
where name ilike '%L%'; -- s.containsIgnoreCase('l')

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
    limit 2;

select * from student
where group_id > 5; -- hides null

select * from student
where group_id > 5 or group_id IS NULL; --

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

-- ------------------------------------------------
select * from student ORDER BY id ASC;
select * from student ORDER BY name ASC, dob DESC;
select * from student ORDER BY dob;
select * from student ORDER BY group_id;
select * from student ORDER BY group_id NULLS FIRST;
select * from student ORDER BY group_id NULLS LAST;

select name, dob,
       CASE
           WHEN group_id is null THEN -100
           ELSE group_id
           END as group2
from student;

select name, dob,
       CASE
           WHEN group_id=1 THEN 'One'
           WHEN group_id=2 THEN 'Two'
           ELSE                 'Other'
           END as group_s
from student;

--     int string
select id, name from student;
--     int        string
select id as id2, name as g_name from groupp;

--     = type 1 =  == type 2 ==
select id as id33, name as item from student
UNION
--     = type 1 =  == type 2 ==
select id as id2, name as g_name from groupp;

-- ----------------------------------------------------------
select * from student;
--     count(xs) -> int
select count(*) from student;
select id, name, (2024 - dob) as age from student;
select id, name, (2024 - dob) as age, now() from student;

select avg(dob) from student;

WITH
    tavg as (select avg(dob) as a1 from student)
select s.id, s.name, tavg.a1 from student s, tavg; -- cartesian product

WITH
    tavg as (select avg(dob) as a1 from student)
select s.id, s.name, tavg.a1 from student s join tavg on true; -- cartesian product

WITH
    tavg as (select avg(dob) as a1 from student)
select s.id, s.name, tavg.a1 from student s cross join tavg; -- cartesian product

select * from student;
select count(*)        from student;-- 11
select count(name)     from student;-- 11
select count(group_id) from student;-- 9

select sum(dob) from student;
select sum(dob)/count(dob) from student;
select avg(dob)from student;

select * from groupp;

select * from student;

select group_id, count(group_id)
from student
where group_id is not null
group by group_id
UNION (
    select null,
           count(*)
    from student where group_id is null
);

WITH
    g_count as (
        select group_id, count(group_id) c2
        from student
        where group_id is not null
        group by group_id
        UNION (
            select null,
                   count(*)
            from student where group_id is null
        )
    )
select g.name, c2 from g_count
                           left outer join groupp g on (g.id = g_count.group_id);

WITH
    g_count as (
        select group_id, count(group_id) c2
        from student
        where group_id is not null
        group by group_id
        UNION (
            select null,
                   count(*)
            from student where group_id is null
        )
    )
select
    CASE
        WHEN g.name IS NULL THEN '<no group>'
        ELSE                     g.name
        END as g_name2,
    c2 from g_count
                left outer join groupp g on (g.id = g_count.group_id);

select name, count(name)
from student
group by name
having count(name) > 1;

WITH
    name_count as (select name, count(name) as c2
                   from student
                   group by name)
select * from name_count where c2 > 1;

select name, lower(name), upper(name) from student;

select '<< ' || name || ' >>' from student;

select * from student;
select distinct name from student;


select name, count(name)
from student
group by name;

select name, dob, count(name)
from student
group by name, dob;
