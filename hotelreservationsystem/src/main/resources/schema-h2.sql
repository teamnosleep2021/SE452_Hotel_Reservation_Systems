DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS hotels;
DROP TABLE IF EXISTS rooms;
DROP TABLE IF EXISTS room_types;
DROP TABLE IF EXISTS reservations;
DROP TABLE IF EXISTS payments;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username varchar(255) not null,
    password_hash varchar(255) not null,
    first_name varchar(255) not null,
    middle_name varchar(255),
    last_name varchar(255) not null,
    email varchar(255) not null,
    UNIQUE(username)
);
CREATE TABLE locations ( 
    id INT AUTO_INCREMENT PRIMARY KEY,
    location_name varchar(255) not null
);
CREATE TABLE hotels (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    hotel_name varchar(255),
    location_id INT not null,
    FOREIGN KEY(location_id) REFERENCES locations(id)
);
CREATE TABLE room_types ( 
    id INT AUTO_INCREMENT PRIMARY KEY,
    type_str varchar(255) not null
);
CREATE TABLE rooms ( 
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_name varchar(255),
    guests INT not null,
    room_type INT not null,
    hotel_id INT not null,
    FOREIGN KEY(hotel_id) REFERENCES hotels(id),
    FOREIGN KEY(room_type) REFERENCES room_types(id)
);
CREATE TABLE reservations ( 
    id INT AUTO_INCREMENT PRIMARY KEY,
    start_dt date default sysdate not null,
    end_dt date not null,
    user_id INT not null,
    room_id INT not null,
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(room_id) REFERENCES rooms(id)
);

CREATE TABLE payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    card_type varchar(255) not null,
    card_holder_name varchar(255) not null,
    card_number varchar(19) not null,
    expiry_dt date not null,
    cvv varchar(3) not null,
    reservation_id INT not null,
    payment_dt date not null default CURRENT_DATE,
    FOREIGN KEY(reservation_id) REFERENCES reservations(id)
);



