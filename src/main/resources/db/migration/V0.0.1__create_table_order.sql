create table orders
(
    id              integer auto_increment primary key,
    product_id      integer,
    status          varchar(16),
    source_customer integer,
    target_customer integer,
    order_date      timestamp
);

insert into orders (product_id, status, source_customer, target_customer, order_date)
values (0, 'PAYE', 0, 0, '2022-08-13T01:00:01.000000800Z');

insert into orders (product_id, status, source_customer, target_customer, order_date)
values (0, 'COMMANDE', 0, 0, '2022-08-14T01:00:01.000000800Z');