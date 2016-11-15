drop SEQUENCE blogs_seq;

create sequence blogs_seq
start with 1
increment by 1
MAXVALUE 9999999999;

drop SEQUENCE categories_seq;

create sequence categories_seq
start with 1
increment by 1
MAXVALUE 9999999999;

drop SEQUENCE comments_seq;

create sequence comments_seq
start with 1
increment by 1
MAXVALUE 9999999999;

drop SEQUENCE posts_seq;

create sequence posts_seq
start with 1
increment by 1
MAXVALUE 9999999999;

drop SEQUENCE users_seq;

create sequence users_seq
start with 1
increment by 1
MAXVALUE 9999999999;


insert 
		into users 
		values( users_seq.nextval, '바밤바', '김진원', '1', sysdate);
		
select * from USERS;

select no, name from users where id = '바밤바' and password= '1';


