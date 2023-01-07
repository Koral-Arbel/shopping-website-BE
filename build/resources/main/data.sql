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
    user_status varchar(300) NOT NULL DEFAULT 'EXTERNAL',
    PRIMARY KEY (user_id)
);

CREATE TABLE user_order (
    order_id int(11) unsigned  NOT NULL AUTO_INCREMENT,
    order_user_id int(11) unsigned NOT NULL,
    order_date date,
    shipping_address varchar(300) NOT NULL DEFAULT '',
    total_price int(300) NOT NULL DEFAULT '',
    order_status varchar(300) DEFAULT '',
    PRIMARY KEY (order_id),
    FOREIGN KEY (order_user_id) REFERENCES user_request(user_id)
);