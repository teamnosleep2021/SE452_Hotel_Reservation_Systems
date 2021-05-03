DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS hotels;
DROP TABLE IF EXISTS rooms;
DROP TABLE IF EXISTS room_types;
DROP TABLE IF EXISTS reservations;
DROP TABLE IF EXISTS payment;

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
    POSTAL_CODE int not null,
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
    cost_per_night DECIMAL not null,
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

create table PAYMENT (
  id INT AUTO_INCREMENT PRIMARY KEY,
  USER_ID int not null,
  CARD_TYPE VARCHAR(50) not null,
  CARD_HOLDER_NAME VARCHAR(100) not null,
  CARD_NUMBER int not null,
  CVV int not null,
  foreign key (USER_ID) REFERENCES USERS(ID)
);



