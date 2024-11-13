#customer table creation
create table Customers (
    customer_id int primary key auto_increment,
    first_name varchar(50),
    last_name varchar(50),
    email varchar(100) unique,
    phone_number int,
    address varchar(50)
);
#room table creation
create table rooms (
    room_id int primary key auto_increment,
    room_type varchar(20),
    room_status varchar(20),
    floor_number int
);

#room price table creation
create table room_price(
	room_type varchar(20),
    price_per_night decimal(10,2)
);

#reservation table creation
create table reservations (
    reservation_id int primary key auto_increment,
    customer_id int,
    room_id int,
    reservation_date date,
    check_in_date date,
    check_out_date date,
    reserv_status varchar(20),
    foreign key (customer_id) references customers(customer_id),
    foreign key (room_id) references rooms(room_id)
);

#payement table creation
create table payments (
    payment_id int primary key auto_increment,
    reservation_id int,
    payment_date date,
    amount_paid decimal(10, 2),
    payment_method varchar(20),
    foreign key (reservation_id) references reservations(reservation_id)
);

# staff table creation
create table staff (
    staff_id int primary key auto_increment,
    first_name varchar(50),
    last_name varchar(50),
    staff_role varchar(20),
    hire_date date
);

#assignment table creation
create table room_assignments (
    assignment_id int primary key auto_increment,
    staff_id int,
    room_id int,
    assignment_date date,
    task_description varchar(255),
    foreign key (staff_id) references staff(staff_id),
    foreign key (room_id) references rooms(room_id)
);