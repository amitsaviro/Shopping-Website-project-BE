

CREATE TABLE customer (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    phone_number varchar(300) NOT NULL DEFAULT '',
    address varchar(300) NOT NULL DEFAULT '',
    user_name varchar(300) NOT NULL DEFAULT '',
    password varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

CREATE TABLE item (
    item_id int(11) unsigned NOT NULL AUTO_INCREMENT,
    item_name varchar(300) NOT NULL DEFAULT '',
    price DECIMAL(10, 2) NOT NULL,
    old_price DECIMAL(10, 2) NOT NULL,
    img_url varchar(300) NOT NULL DEFAULT '',
    category varchar(300) NOT NULL DEFAULT '',
    stock int(11) NOT NULL,
    PRIMARY KEY (item_id)
);

CREATE TABLE order_list (
    order_list_id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11),
    order_date varchar(300) NOT NULL DEFAULT '',
    shipping_address varchar(300) NOT NULL DEFAULT '',
    total_price DECIMAL(10, 2) NOT NULL,
    status varchar(300) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE,
    PRIMARY KEY (order_list_id )
);

CREATE TABLE order_item (
    order_item_id  int(11) unsigned NOT NULL AUTO_INCREMENT,
    order_id int(11),
    item_id int(11),
    quantity int(11) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES order_list(order_list_id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES item(item_id),
    PRIMARY KEY (order_item_id)
);


CREATE TABLE favorite_list (
    favorite_list_id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11),
    item_id int(11),
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES item(item_id),
    PRIMARY KEY (favorite_list_id)
);

INSERT INTO item (item_name, old_price, price, img_url, category, stock)
VALUES
    ('Classic Ball', 49.90, 70.00, 'logo.png', 'football', 10),
    ('Green & Red Ball', 55.00, 60.90, 'greenRed.png', 'football', 0),
    ('Orange & Blue Ball', 49.90, 55.00, 'orangeBlue.png', 'football', 4),
    ('Red & White Ball', 35.60, 50.00, 'redWhite.png', 'football', 30),
    ('Yellow & Red Ball', 50.00, 74.99, 'yellowRed.png', 'football', 10),
    ('Yellow & Black Ball', 38.00, 40.50, 'yellowBlack.png', 'football', 7),
    ('Classic Volleyball', 30.00, 40.00, 'classicVB.png', 'volleyball', 100),
    ('Gray Volleyball', 35.00, 58.80, 'grayVB.png', 'volleyball', 0),
    ('Beach Volleyball', 20.00, 30.00, 'chVB.png', 'volleyball', 12),
    ('Volleyball Bag', 9.90, 19.90, 'saloBag.jpg', 'volleyball', 60),
    ('Black Hat', 15.99, 24.90, 'blackHat.jpg', 'hats', 50),
    ('Red Hat', 19.99, 24.90, 'redHat.jpg', 'hats', 70),
    ('Gray Hat', 19.99, 24.90, 'grayHat.jpg', 'hats', 200),
    ('White Hat', 19.99, 24.90, 'whiteHat.jpg', 'hats', 40);

