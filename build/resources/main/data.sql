DROP TABLE IF EXISTS user_request;
DROP TABLE IF EXISTS user_order;

CREATE TABLE user_request (
    user_id int(11) unsigned  NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    phone varchar(300) NOT NULL,
    country varchar(300) NOT NULL DEFAULT '',
    city varchar(300) NOT NULL,
    PRIMARY KEY (user_id)
);

--CREATE TABLE user_order (
--    order_id int(11) unsigned  NOT NULL AUTO_INCREMENT,
--    user_id int(11) unsigned NOT NULL,
--    order_date date,
--    country varchar(300) NOT NULL DEFAULT '',
--    city varchar(300) NOT NULL DEFAULT '',
--    shipping_address varchar(300) NOT NULL DEFAULT '',
--    total_price varchar(300) NOT NULL DEFAULT '',
--    order_status varchar(300) DEFAULT '',
--    PRIMARY KEY (id),
--    FOREIGN KEY (user_id) REFERENCES user_request(user_id)
--);