CREATE TABLE USUARIOS_HOTEL
(
	username text,
	password text,
	hotel_name text,
	PRIMARY KEY(user_name),
	FOREIGN KEY(hotel_name) REFERENCES HOTELES ON DELETE CASCADE,
	FOREIGN KEY(username) REFERENCES USUARIOS ON DELETE CASCADE

);

CREATE TABLE HOTELES
(
	hotel_name text,
	address text,
	rate float,
	city text,
	PRIMARY KEY(hotel_name)
);

CREATE TABLE COMENTARIOS
(
	hotel_name text,
	username text,
	comment text,
	comment_date timestamp,
	PRIMARY KEY(hotel_name, username,  comment_date),
	FOREIGN KEY(hotel_name) REFERENCES HOTELES ON DELETE CASCADE,
	FOREIGN KEY(username) REFERENCES USUARIOS ON DELETE CASCADE
);

CREATE TABLE FOTOS
(
	hotel_name text,
	photo text,
	PRIMARY KEY(hotel_name, photo),
	FOREIGN KEY(hotel_name) REFERENCES HOTELES ON DELETE CASCADE

);


CREATE TABLE HABITACIONES
(
	room_type text,
	capacity int,
	room_number int,
	hotel_name text,
	room_view text,
	PRIMARY KEY(room_number, hotel_name),
	FOREIGN KEY(hotel_name) REFERENCES HOTELES(hotel_name) ON DELETE CASCADE,
	FOREIGN KEY(hotel_name, room_type) REFERENCES TIPOS_HAB(hotel_name, room_type) ON DELETE SET NULL

);

CREATE TABLE RESERVAS
(
	username text,
	reservation_number int,
	check_in date,
	check_out date,
	room_number int,
	hotel_name text,
	PRIMARY KEY(reservation_number, room_number, hotel_name),
	FOREIGN KEY(username) REFERENCES USUARIOS ON DELETE CASCADE,
	FOREIGN KEY(hotel_name, room_number) REFERENCES HABITACIONES(hotel_name, room_number) ON DELETE CASCADE

);

CREATE TABLE USUARIOS
(
	email text,
	password text,
	username text,
	name text,
	surname text,
	document text,
	country text,
	province text,
	city text,
	street text,
	street_number text,
	cp text,
	phone text,
	phone_type text,
	PRIMARY KEY(username)

);

CREATE TABLE TIPOS_HAB
(
	room_type text,
	features text,
	hotel_name text,
	cost float,
	PRIMARY KEY(room_type, hotel_name),
	FOREIGN KEY(hotel_name) REFERENCES HOTELES ON DELETE CASCADE
);