create table orders
(
    id              integer auto_increment primary key,
    product_id      integer,
    status          varchar(16),
    source_customer integer,
    target_customer integer,
    order_date      timestamp
);