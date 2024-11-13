# Retrieve all information about rooms available on a specific floor.
select * from rooms 
inner join reservations on rooms.room_id=reservations.room_id 
where floor_number=2;

#List all reservations with customer details (first name, last name, email), 
#sorted by check-in date (earliest first).
select c.first_name, c.last_name, c.email, r.*
from customers as c
inner join reservations as r on c.customer_id=r.customer_id
order by check_in_date;

#Find all customers who have reserved rooms for more than 5 nights.
select c.customer_id,c.first_name, c.last_name, r.room_id,
r.check_in_date,r.check_out_date 
from customers as c inner join reservations as r
on c.customer_id=r.customer_id 
where timestampdiff
		(day, r.check_in_date, r.check_out_date) > 5;
        
#Get the total amount paid for each reservation.
select reservation_id, sum(amount_paid)
from payments
group by reservation_id;

#Find the average room price for each room type.
select room_type, avg(price_per_night)
from room_price
group by room_type;

#Display the total revenue generated from all reservations in the last month.
select sum(amount_paid)
from payments
where timestampdiff(month, payment_date, curdate()) = 1;

#Find the staff members who have been, 
#assigned the most rooms for cleaning or maintenance in the last month.
select s.staff_id, s.first_name,count(r.assignment_id) as count
from staff as s inner join room_assignments as r 
on s.staff_id=r.staff_id
where timestampdiff(month,r.assignment_date,curdate())=1
group by s.staff_id;

#Retrieve the most recent reservation for each customer.
select c.customer_id, c.first_name,
r.reservation_date
from customers c
inner join reservations r on c.customer_id = r.customer_id
where r.reservation_date = (
    select max(reservation_date)
    from reservations
    where customer_id = c.customer_id)
order by c.customer_id;

#Delete a reservation and all corresponding payment records.on cascade
alter table payments
add constraint fk_reservation
foreign key (reservation_id) references reservations(reservation_id)
on delete cascade;
delete from reservations
where reservation_id = 1;

#bonus
#Room Availability Check: Create a query that checks which rooms 
#are available for a given date range (i.e., not reserved for those dates).