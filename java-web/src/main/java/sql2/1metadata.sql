create table student
(
    id       serial constraint student_pk primary key,
    name     text,
    dob      integer,
    group_id integer
);

create table groupp
(
    id    serial constraint groupp_pk primary key,
    name  text,
    start date
);

create table t
(
    n integer
);
