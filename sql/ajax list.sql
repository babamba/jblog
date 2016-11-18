select * from category;
select * from users;
select * from POSTS;

select 	CATEGORY_NAME, 
		CATEGORY_NO, 
		DESCRIPTION, 
		to_char(REG_DATE, 'yyyy-mm-dd hh:mi:ss' ) as regDate
from category
order by USERS_NO desc;

insert into POSTS values (POSTS_SEQ.nextval, '카테고리5', '제목' , sysdate, 5);

SELECT c.category_no AS categoryNo, 
	   c.users_no AS userNo,
	   c.category_name AS categoryName, 
	   c.description,
	   c.reg_date AS regDate, 
	   p.num AS count
 	  	FROM CATEGORY c,
		     (SELECT CATEGORY_NO, 
			 		 COUNT (*) as num
           		   		 FROM POSTS
        	  GROUP BY CATEGORY_NO) p
 WHERE p.CATEGORY_NO (+)= c.category_no
 		 AND c.USERS_NO = 38;
			  
SELECT CATEGORY_NO, COUNT (*) as  FROM POST GROUP BY CATEGORY_NO;