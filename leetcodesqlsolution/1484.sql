
select sell_date,count(DISTINCT product) as num_sold, group_concat(DISTINCT product ORDER BY product asc) AS products from Activities  group by sell_date order by sell_date;