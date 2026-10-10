select customer_id from Customer c  join Product p  group by c.customer_id having count(distinct  c.product_key) = count(distinct p.product_key) ;


-- select customer_id from Customer  group by customer_id having count(distinct product_key)=(select count(distinct product_key) from product);