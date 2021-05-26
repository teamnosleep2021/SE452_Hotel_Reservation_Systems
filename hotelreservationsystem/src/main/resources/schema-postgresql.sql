DROP TABLE IF EXISTS PAYMENT CASCADE;
DROP TABLE IF EXISTS RESERVATIONS CASCADE;
DROP TABLE IF EXISTS ROOMS CASCADE;
DROP TABLE IF EXISTS ROOM_TYPES CASCADE;
DROP TABLE IF EXISTS HOTELS CASCADE; 
DROP TABLE IF EXISTS LOCATIONS CASCADE;
DROP TABLE IF EXISTS ROLES CASCADE;
DROP TABLE IF EXISTS USERS CASCADE;
DROP TABLE IF EXISTS USERS_ROLES CASCADE;

create table USERS (
  -- ID = UserID
  USER_ID int generated by default as identity not null,
  USERNAME varchar(255) not null,
  PASSWORD_HASH varchar(255) not null,
  FIRST_NAME varchar(255) not null,
  MIDDLE_NAME varchar(255),
  LAST_NAME varchar(255) not null,
  EMAIL varchar(255) not null,
  ENABLED BOOLEAN,
  primary key (USER_ID),
  unique (USERNAME)
);

create table ROLES (
  ROLE_ID int generated by default as identity not null,
  ROLE_NAME VARCHAR(255),
  primary key (ROLE_ID)
);

create table USERS_ROLES (
    USER_ID int,
    ROLE_ID int, 
    foreign key (USER_ID) references USERS (USER_ID),
    foreign key (ROLE_ID) references ROLES (ROLE_ID)
);

create table LOCATIONS (
  -- ID = LocationID
  ID int generated by default as identity not null,
  LOCATION_NAME varchar(255) not null,
  primary key (ID)
);

create table HOTELS (
  -- ID = HotelID
  ID int generated by default as identity not null,
  HOTEL_NAME varchar(255),
  LOCATION_ID int not null,
  POSTAL_CODE int not null,
  primary key (ID),
  foreign key (LOCATION_ID)
  references LOCATIONS (ID)
);

create table ROOM_TYPES (
  -- ID = RoomTypeID
  ID int generated by default as identity not null,
  ROOM_TYPE_STR varchar(255) not null,
  primary key (ID)
);

create table ROOMS (
  -- ID = RoomID for a specific hotel's room type  
  ID int generated by default as identity not null,
  room_name varchar(255),
  ROOM_TYPE_ID int not null,
  HOTEL_ID int not null,
  GUESTS int not null,
  COST_PER_NIGHT int not null,  
  primary key (ID),
  foreign key (HOTEL_ID)
  references HOTELS (ID),
  foreign key (ROOM_TYPE_ID)
  references ROOM_TYPES (ID)
);

create table RESERVATIONS(
    ID int GENERATED ALWAYS AS IDENTITY,
    START_DT date not null,
    END_DT date not null, 
    USER_ID int not null,
    ROOM_ID int not null,
    PRIMARY KEY (ID),
    FOREIGN KEY(USER_ID) REFERENCES USERS(USER_ID),
    FOREIGN KEY(ROOM_ID) REFERENCES ROOMS(ID));

create table PAYMENT (
  ID int generated by default as identity not null,
  USER_ID int not null,
  CARD_TYPE varchar(50) not null,
  CARD_HOLDER_NAME varchar(100) not null,
  CARD_NUMBER int not null,
  CVV int not null,
  primary key (ID),
  foreign key (USER_ID)
  references USERS (USER_ID)
);
