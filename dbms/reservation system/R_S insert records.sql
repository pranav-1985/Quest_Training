# customer records insertion
insert into customers (first_name, last_name, email, phone_number, address) 
values
('john', 'doe', 'john.doe@example.com', '224455', '123 main street'),
('jane', 'smith', 'jane.smith@example.com', '212325', '456 oak avenue'),
('alice', 'johnson', 'alice.johnson@example.com', '353739', '789 pine road'),
('bob', 'brown', 'bob.brown@example.com', '456781', '101 maple lane'),
('carol', 'davis', 'carol.davis@example.com', '567890', '202 cedar street');

# rooms record insertion
insert into rooms (room_type, room_status, floor_number) 
values
('single','available', 1),
('double','occupied', 2),
('suite','available', 3),
('single','under maintenance', 1),
('double','available', 2);

#roomprice table insertion
insert into room_price(room_type,price_per_night)
values
('single',100.00),
('double',200.00),
('suite',300.00);

#reservations table insertion
insert into reservations (customer_id, room_id, reservation_date, check_in_date, check_out_date, reserv_status) 
values
(11, 3, '2024-11-01', '2024-11-05', '2024-11-10', 'confirmed'),
(12, 2, '2024-11-02', '2024-11-06', '2024-11-12', 'confirmed'),
(13, 1, '2024-11-03', '2024-11-07', '2024-11-11', 'cancelled'),
(14, 5, '2024-11-04', '2024-11-05', '2024-11-08', 'completed'),
(15, 3, '2024-11-05', '2024-11-09', '2024-11-14', 'confirmed'),
(13, 1, '2024-11-10', '2024-11-11', '2024-11-19', 'confirmed');

# Insert records into payments
insert into payments (reservation_id, payment_date, amount_paid, payment_method)
values
(1, '2024-11-01', 500.00, 'credit card'),
(2, '2024-11-02', 900.00, 'cash'),
(3, '2024-11-03', 0.00, 'credit card'),
(5, '2024-11-05', 500.00, 'cash'),
('3', '2024-11-03', '10.00', 'credit card');

# staff table insert
insert into staff (first_name, last_name, staff_role, hire_date) 
values
('mike', 'wilson', 'receptionist', '2023-01-15'),
('susan', 'lee', 'manager', '2022-03-22'),
('kevin', 'martin', 'housekeeper', '2021-05-30'),
('rachel', 'garcia', 'receptionist', '2023-07-10'),
('tom', 'brown', 'housekeeper', '2022-11-18');

# room_assignments table insertion
insert into room_assignments (staff_id, room_id, assignment_date, task_description) 
values
(3, 1, '2024-11-06', 'cleaning'),
(3, 2, '2024-10-07', 'cleaning'),
(5, 4, '2024-11-08', 'maintenance'),
(3, 5, '2024-10-09', 'cleaning'),
(2, 3, '2024-11-10', 'inspection');
