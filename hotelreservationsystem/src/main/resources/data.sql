-- populate users table

INSERT INTO Users(username, password_hash, first_name, middle_name, last_name, email)
VALUES('LeoD', 'leo123', 'Leonardo', 'J.','DiCaprio', 'leoD@gmail.com');
INSERT INTO Users(username, password_hash, first_name, middle_name, last_name, email)
VALUES('JackieC', 'jack123', 'Jackie', 'A.','Chan', 'jackiechan@gmail.com');
INSERT INTO Users(username, password_hash, first_name, middle_name, last_name, email)
VALUES('BruceL', 'bruce123', 'Bruce', 'S.','Lee', 'brucelee@ymail.com');
INSERT INTO Users(username, password_hash, first_name, middle_name, last_name, email)
VALUES('ChristK', 'Christ123', 'Christopher', 'R.','Nolan', 'ChristNolan@gmail.com');
INSERT INTO Users(username, password_hash, first_name, middle_name, last_name, email)
VALUES('TomC', 'Tom123', 'Tom', 'K.','Cruise', 'tomcruise@gmail.com');

-- populate locations
insert into locations(location_name) VALUES('Chicago');
insert into locations(location_name) values ('California');
insert into locations(location_name) values ('Texas');
insert into locations(location_name) values ('Florida');
insert into locations(location_name) values ('Colorado');

-- populate hotels
insert into hotels (hotel_name, location_id) values ('Hilton Chicago', '1');
insert into hotels (hotel_name, location_id) values ('Trump International Hotel', '1');
insert into hotels (hotel_name, location_id) values ('The Aloft', '1');
insert into hotels (hotel_name, location_id) values ('San Jose Marrott', '2');
insert into hotels (hotel_name, location_id) values ('Fairmont Dallas', '3');
insert into hotels (hotel_name, location_id) values ('Sheraton Dallas Hotel', '3');
insert into hotels (hotel_name, location_id) values ('Bay Street Inn', '4');
insert into hotels (hotel_name, location_id) values ('Comfort Inn & Suite', '4');
insert into hotels (hotel_name, location_id) values ('Walt Disney World Swan', '4');
insert into hotels (hotel_name, location_id) values ('Embassy Suites Colorado', '5');
insert into hotels (hotel_name, location_id) values ('Magnolia Hotel Denver', '5');

-- populate room_types
insert into room_types(type_str) values('Single Room');
insert into room_types(type_str) values('Double Room');
insert into room_types(type_str) values('Duplex Room');

-- populate rooms
insert into rooms(room_type, hotel_id, guests) values (1, 1 , 2);
insert into rooms(room_type, hotel_id, guests) values (2, 1 , 4);
insert into rooms(room_type, hotel_id, guests) values (3, 1 , 6);
insert into rooms(room_type, hotel_id, guests) values (1, 2 , 2);
insert into rooms(room_type, hotel_id, guests) values (2, 2 , 4);
insert into rooms(room_type, hotel_id, guests) values (3, 2 , 6);
insert into rooms(room_type, hotel_id, guests) values (1, 3 , 2);
insert into rooms(room_type, hotel_id, guests) values (2, 3 , 4);
insert into rooms(room_type, hotel_id, guests) values (3, 4 , 6);
insert into rooms(room_type, hotel_id, guests) values (1, 5 , 2);
insert into rooms(room_type, hotel_id, guests) values (2, 5 , 4);
insert into rooms(room_type, hotel_id, guests) values (3, 5 , 6);
insert into rooms(room_type, hotel_id, guests) values (1, 6 , 2);
insert into rooms(room_type, hotel_id, guests) values (2, 6 , 4);
insert into rooms(room_type, hotel_id, guests) values (3, 6 , 6);
insert into rooms(room_type, hotel_id, guests) values (1, 7 , 2);
insert into rooms(room_type, hotel_id, guests) values (2, 7 , 4);
insert into rooms(room_type, hotel_id, guests) values (3, 7 , 6);
insert into rooms(room_type, hotel_id, guests) values (1, 8 , 2);
insert into rooms(room_type, hotel_id, guests) values (2, 8 , 4);
insert into rooms(room_type, hotel_id, guests) values (3, 8 , 6);
insert into rooms(room_type, hotel_id, guests) values (1, 9 , 2);
insert into rooms(room_type, hotel_id, guests) values (2, 10 , 4);
insert into rooms(room_type, hotel_id, guests) values (3, 11 , 6);


-- populate reservations

insert into reservations(start_dt, end_dt, user_id, room_id) values('2021-04-15','2021-04-20',2,4);
insert into reservations(start_dt, end_dt, user_id, room_id) values('2021-05-20','2021-05-25',1,9);
insert into reservations(start_dt, end_dt, user_id, room_id) values('2021-11-20','2021-11-21',1,9);
insert into reservations(start_dt, end_dt, user_id, room_id) values('2021-04-15','2021-04-24',3,23);

