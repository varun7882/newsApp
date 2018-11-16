LOAD DATA INFILE 'C:\\Users\\Vasrivastava\\Downloads\\news_bulletin666200b.csv' 
INTO TABLE article
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
;
select * from article