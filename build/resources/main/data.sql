DROP TABLE IF EXISTS user_request;
DROP TABLE IF EXISTS user_order;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS favorite_item_list;
DROP TABLE IF EXISTS employee_user_order;
DROP TABLE IF EXISTS employee_user_favorite_item;

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
    order_date date,
    shipping_address varchar(300) NOT NULL DEFAULT '',
    total_price int(300) NOT NULL DEFAULT '',
    order_status varchar(300) DEFAULT '',
    order_user_id int(11) unsigned  NOT NULL,
    PRIMARY KEY (order_id)
);

CREATE TABLE item (
     item_id int(11) unsigned  NOT NULL AUTO_INCREMENT,
     item_name varchar(300) NOT NULL,
     item_price int(300) NOT NULL,
     PRIMARY KEY(item_id)
);

CREATE TABLE favorite_item_list (
    favorite_item_id int(11) unsigned  NOT NULL AUTO_INCREMENT,
    user_id int(11) unsigned  NOT NULL,
    item_id int(11) unsigned  NOT NULL,
    PRIMARY KEY(favorite_item_id)
);

CREATE TABLE employee_user_order(
     id int(11) unsigned  NOT NULL AUTO_INCREMENT,
     order_user_id int(11) unsigned NOT NULL,
     item_id int(11) unsigned  NOT NULL,
     FOREIGN KEY (order_user_id) REFERENCES user_request(user_id),
     FOREIGN KEY (item_id) REFERENCES item(item_id),
     PRIMARY KEY(id)
);

CREATE TABLE employee_user_favorite_item(
     id int(11) unsigned  NOT NULL AUTO_INCREMENT,
     favorite_item_id int(11) unsigned  NOT NULL,
     user_id int(11) unsigned  NOT NULL,
     FOREIGN KEY (favorite_item_id) REFERENCES favorite_item_list(favorite_item_id),
     FOREIGN KEY (user_id) REFERENCES user_request(user_id),
     PRIMARY KEY(id)
);

--INSERT INTO user_order (item_name, order_date) VALUES
--('iPhone14', '2023-07-29'),
--('iPhone13', '2023-07-25'),
--('iPhone12', '2023-07-19'),
--('iPhone11', '2023-07-14'),






