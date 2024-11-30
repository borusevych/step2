-- january
create table shares
(
    action text,
    amount integer,
    name   text
);

-- february
alter table shares add column price integer;

-- ...
alter table shares add column info text;
-- ...
-- ...

INSERT INTO shares (action, amount, name, price) VALUES ('buy', 10, 'GOOGLE', 1000);
INSERT INTO shares (action, amount, name, price) VALUES ('sell', 10, 'GOOGLE', 1100);
INSERT INTO shares (action, amount, name, price) VALUES ('buy', 10, 'GOOGLE', 1100);
INSERT INTO shares (action, amount, name, price) VALUES ('sell', 5, 'GOOGLE', 1200);
INSERT INTO shares (action, amount, name, price) VALUES ('sell', 5, 'GOOGLE', 1090);
INSERT INTO shares (action, amount, name, price) VALUES ('buy', 10, 'APPLE', 1000);
INSERT INTO shares (action, amount, name, price) VALUES ('sell', 3, 'APPLE', 900);
INSERT INTO shares (action, amount, name, price) VALUES ('sell', 7, 'APPLE', 1200);

-- =========================================================
select * from shares;

-- ----------------------
select action, amount, name, price from shares;

-- ----------------------
select action,
       CASE
           WHEN s.action = 'buy' THEN -1
           WHEN s.action = 'sell' THEN 1
           ELSE null
           END as k,
       amount, name, price from shares s;

-- ----------------------
WITH
    shares2 as (
        select name,
               CASE
                   WHEN s.action = 'buy' THEN -1
                   WHEN s.action = 'sell' THEN 1
                   ELSE null
                   END as k,
               amount * price as s1 from shares s
    ),
    total2 as (
        SELECT name, (k * s1) as total from shares2
    )
select name, sum(total)
from total2
group by name;
