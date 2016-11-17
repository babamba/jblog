insert INTO categories values (categories_seq.nextval, '카테고리', '내용 설명', sysdate, 21);

select * from categories;

select * from users;

select no, name, des, to_char(reg_date,'yyyy-mm-dd hh:mi:ss') as regDate, users_no as userNo from categories where no= 1;

insert INTO CATEGORY values (1, '카테고리', '내용 설명', sysdate, 3) ;

SELECT no, users_no AS userNo, name, description, reg_date AS regDate FROM CATEGORIES WHERE no = '3';