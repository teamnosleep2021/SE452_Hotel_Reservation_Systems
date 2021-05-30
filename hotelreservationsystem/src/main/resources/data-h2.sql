-- populate users table
-- Initial table population
INSERT INTO users(username, password_hash, first_name, middle_name, last_name, email, enabled) VALUES
    ('LeoD', '$2a$10$ocecgV0tbvt9ARWMryvHmeKPiMAL.LnK5u3f1SQEgtsgFXcS1X1dW', 'Leonardo', 'J.','DiCaprio', 'leoD@gmail.com', TRUE),
    ('JackieC', '$2a$10$ocecgV0tbvt9ARWMryvHmeKPiMAL.LnK5u3f1SQEgtsgFXcS1X1dW', 'Jackie', 'A.','Chan', 'jackiechan@gmail.com', TRUE),
    ('BruceL', '$2a$10$ocecgV0tbvt9ARWMryvHmeKPiMAL.LnK5u3f1SQEgtsgFXcS1X1dW', 'Bruce', 'S.','Lee', 'brucelee@ymail.com', TRUE),
    ('ChristK', '$2a$10$ocecgV0tbvt9ARWMryvHmeKPiMAL.LnK5u3f1SQEgtsgFXcS1X1dW', 'Christopher', 'R.','Nolan', 'ChristNolan@gmail.com', TRUE),
    ('TomC', '$2a$10$ocecgV0tbvt9ARWMryvHmeKPiMAL.LnK5u3f1SQEgtsgFXcS1X1dW', 'Tom', 'K.','Cruise', 'tomcruise@gmail.com', TRUE);

-- populate ROLES table
-- Initial table population
INSERT INTO roles(role_name) VALUES('USER');
INSERT INTO roles(role_name) VALUES('ADMIN');

-- populate USERS_ROLES table
-- Initial table population
INSERT INTO users_roles (user_id, role_id) VALUES(1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES(2, 1);
INSERT INTO users_roles (user_id, role_id) VALUES(2, 2);


-- populate locations
INSERT INTO LOCATIONS (address_str,city,state_cd,POSTAL_CODE) VALUES
    ('198 E Delaware Pl','Chicago','Illinois',60611),
    ('401 N Wabash Ave','Chicago','Illinois',60601),
    ('243 E Ontario St','Chicago','Illinois',60611),
    ('301 S Market St','San Jose','California',95113),
    ('1717 N Akard St','Dallas','Texas', 75201),
    ('400 N Olive St','Dallas','Texas', 75201),
    ('635 Bay St NE','St. Petersburg','Florida', 33701),
    ('1200 Epcot Resorts Blvd','Lake Buena Vista','Florida', 32830),
    ('7290 Commerce Center Dr','Colorado Springs','Colorado', 80919),
    ('818 17th St','Denver','Colorado', 80202);

-- populate hotels
insert into hotels (hotel_name, location_id) values ('Hilton Chicago', 1);
insert into hotels (hotel_name, location_id) values ('Trump International Hotel', 2);
insert into hotels (hotel_name, location_id) values ('The Aloft', 3);
insert into hotels (hotel_name, location_id) values ('San Jose Marriott', 4);
insert into hotels (hotel_name, location_id) values ('Fairmont Dallas', 5);
insert into hotels (hotel_name, location_id) values ('Sheraton Dallas Hotel', 6);
insert into hotels (hotel_name, location_id) values ('Bay Street Inn', 7);
insert into hotels (hotel_name, location_id) values ('Walt Disney World Swan', 8);
insert into hotels (hotel_name, location_id) values ('Embassy Suites Colorado', 9);
insert into hotels (hotel_name, location_id) values ('Magnolia Hotel Denver', 10);

-- populate room_types
insert into room_types(ROOM_TYPE_STR) values('Single Room');
insert into room_types(ROOM_TYPE_STR) values('Double Room');
insert into room_types(ROOM_TYPE_STR) values('Queen Room');

-- populate rooms
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (1, 1 , 2, 250,'R1');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (2, 1 , 4, 500,'R2');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (3, 1 , 6, 800,'R3');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (1, 2 , 2, 300,'R1');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (2, 2 , 4, 600,'R2');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (3, 2 , 6, 1000,'R3');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (1, 3 , 2, 150,'R1');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (2, 3 , 4, 250,'R2');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (3, 4 , 6, 400,'R1');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (1, 5 , 2, 250,'R1');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (2, 5 , 4, 500,'R2');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (3, 5 , 6, 800,'R3');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (1, 6 , 2, 650,'R1');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (2, 6 , 4, 750,'R2');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (3, 6 , 6, 1200,'R3');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (1, 7 , 2, 200,'R1');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (2, 7 , 4, 400,'R2');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (3, 7 , 6, 600,'R3');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (1, 8 , 2, 300,'R1');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (2, 8 , 4, 350,'R2');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (3, 8 , 6, 650,'R3');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (1, 9 , 2, 150,'R1');
insert into rooms(ROOM_TYPE_ID, hotel_id, guests, COST_PER_NIGHT,room_name) values (2, 10 , 4, 400,'R1');


-- populate reservations
insert into RESERVATIONS(START_DT, END_DT, USER_ID, ROOM_ID) values('2021-04-15','2021-04-20',2,4);
insert into RESERVATIONS(START_DT, END_DT, USER_ID, ROOM_ID) values('2021-05-20','2021-05-25',1,9);
insert into RESERVATIONS(START_DT, END_DT, USER_ID, ROOM_ID) values('2021-11-20','2021-11-25',1,9);
insert into RESERVATIONS(START_DT, END_DT, USER_ID, ROOM_ID) values('2021-04-15','2021-04-25',3,23);

-- populate payment table
insert into payment(user_id, card_type, card_holder_name, card_number, cvv, exp_dt) values(2, 'Master Card','Jackie Chan',125175212, 456,'2021-04-15');

