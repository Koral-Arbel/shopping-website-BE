DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS favorite_list;
DROP TABLE IF EXISTS favorite;
DROP TABLE IF EXISTS user_order;
DROP TABLE IF EXISTS order_list;


CREATE TABLE user (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     username varchar(20) NOT NULL DEFAULT '',
     password varchar(20) NOT NULL DEFAULT '',
     active tinyint(1) NOT NULL DEFAULT '1',
     roles varchar(200) NOT NULL DEFAULT '',
     permissions varchar(200) NOT NULL DEFAULT '',
     PRIMARY KEY (id)
);

CREATE TABLE item (
     item_id int(11) unsigned  NOT NULL AUTO_INCREMENT,
     title varchar(300) NOT NULL,
     price int(11) NOT NULL,
     image varchar(300) NOT NULL,
     quantity_available int(11) NOT NULL,
     PRIMARY KEY(item_id)
);

CREATE TABLE favorite_list (
    favorite_id int(11) unsigned  NOT NULL AUTO_INCREMENT,
    username varchar(20) NOT NULL,
    item_id int(11) unsigned  NOT NULL,
    quantity_item int(11) unsigned  NOT NULL,
    FOREIGN KEY(item_id) REFERENCES item(item_id),
);

CREATE TABLE favorite (
    favorite_id int(11) unsigned NOT NULL AUTO_INCREMENT,
    username varchar(20) NOT NULL,
    PRIMARY KEY (favorite_id),
    FOREIGN KEY(username) REFERENCES user(username)
);

CREATE TABLE user_order (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    username varchar(20) NOT NULL ,
    date DATE NOT NULL DEFAULT '',
    shipping_address varchar(300) NOT NULL DEFAULT '',
    total_price int(11) NOT NULL DEFAULT '',
    order_status varchar(300) NOT NULL DEFAULT 'TEMP',
    PRIMARY KEY (id),
    FOREIGN KEY (username) REFERENCES user(username)
);

CREATE TABLE order_list (
    order_list_id int(20) unsigned NOT NULL AUTO_INCREMENT,
    username varchar(20) NOT NULL,
    item_id int(11) NOT NULL,
    quantity_item int(11) NOT NULL,
    FOREIGN KEY(item_id) REFERENCES item(item_id)
);

INSERT INTO user (username, password, active, roles, permissions) VALUES
    ('dan', '1234', 1, '', ''),
    ('alon', '12345', 1, '', '');

INSERT INTO item (title, price, image, quantity_available) VALUES
('Airpods2', 400.99, 'http://atlas-content-cdn.pixelsquid.com/stock-images/apple-airpods-earphones-exdGm2B-600.jpg', 12),
('AirpodsPro', 599.99, 'https://static.esrgear.com/blog/wp-content/uploads/2022/06/airpods-pro-magsafe-case.png', 8),
('Buds', 349.99, 'https://www.imgshop.co.il/images/itempics/3638_260120211231561_large.jpg', 10),
('Laptop', 3299.99, 'https://cdn.pixabay.com/photo/2020/10/21/18/07/laptop-5673901__340.jpg', 9),
('Apple Watch', 2500.99, 'https://photos5.appleinsider.com/gallery/50368-99094-000-lead-Two-Apple-Watches-xl.jpg', 12),
('iPhone-12', 3029.99, 'https://gadget-team.co.il/wp-content/uploads/2021/03/12-Apple-iPhone-12-128G-.jpg', 10),
('iphone-12ProMax',3999.99, 'https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-12-pro-max-2.jpg', 13),
('iPhone-13-ProMax', 4029.99, 'https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-13-pro-max-2.jpg', 12),
('iPhone-11', 2500.99, 'https://gadget-team.co.il/wp-content/uploads/2021/03/IPHONE-11.jpg', 12),
('iPhone-11ProMax', 3900.99, 'https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-pro-10.jpg', 12);


