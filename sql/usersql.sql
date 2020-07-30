desc user;
-- select
select * from user;

-- 회원가입
insert into user values(null, '안대혁', 'kickscar@gmail.com', password('1234'), 'male', now());

-- login
select no, name from user where email='kickscar@gmail.com' and password=password('1234');