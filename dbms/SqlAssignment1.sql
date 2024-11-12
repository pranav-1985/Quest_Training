--author table creation
create table Authors(author_id int primary key auto_increment,
                     first_name varchar(50),
                     last_name varchar(50));

--book table creation
create table Books (
                       book_id int primary key auto_increment,
                       title varchar(100),
                       author_id int,
                       publication_year year,
                       price decimal(10, 2),
                       foreign key (author_id) references Authors(author_id));

--borrowers table creation
create table Borrowers(borrower_id int primary key auto_increment,
                       first_name varchar(50),
                       last_name varchar(50),
                       email varchar(50) unique,
                       dob date);

--Loans table creation
create table Loans(loan_id int primary key auto_increment,
                   borrower_id int,
                   book_id int,
                   loan_date date,
                   return_date date,
                   foreign key(borrower_id) references Borrowers(borrower_id),
                   foreign key(book_id) references Books(book_id));

--inserting into authors table (no need for author_id as it auto increments)
insert into authors(first_name,last_name)
values("John","Levy"),
      ("Abraham","Lincoln"),
      ("Oscar","Wilde"),
      ("William","Shakespheare"),
      ("Robin","Williams");

--inserting into books table (no need for book_id as it auto increments)
insert into books(title,author_id,publication_year,price)
values
    ("Who Knows",1,2020,200.00),
    ("Gettysburg Address",2,1963,300.00),
    ("The Picture of Dorian Gray",3,1990, 188.50),
    ("Hamlet",4,1903,312.75),
    ("O captain My captain",5, 2020, 225.00);

--inserting into borrowers table (no need for borrower_id as it auto increments)
insert into borrowers(first_name,last_name,email,dob)
values("John","Reese","reese@yahoo.com","1988-12-05"),
      ("Thomas","Andre","andrethomas@gmail.com","1998-10-07"),
      ("Shaw","Smith","smith@yahoo.com","2008-2-25"),
      ("Brook","King","king@gmail.com","1999-07-17"),
      ("Roger","D","gol.d@yahoo.com","2002-12-03");

--inserting into loans table (no need for loan_id as it auto increments)
insert into Loans (borrower_id, book_id, loan_date, return_date)
values
    (1, 30, '2024-10-01', '2024-10-15'),
    (2, 29, '2023-11-01', '2023-11-15'),
    (3, 28, '2024-10-10', '2024-10-20'),
    (4, 27, '2023-11-05', '2022-11-19'),
    (5, 26, '2024-10-15', '2024-10-25');

--selects every book from books table
select * from books;

--select every book which has price above 200
select title,price,publication_year from books where price>200;

--selects every borrower who has borrowed a book after the date 01-01-2024
select first_name, last_name,email from borrowers
where borrower_id in (select borrower_id from loans where loan_date>'2024-01-01');

--updates the price of the book "who knows" to 100
update books set price=100.00
where title="Who Knows";

--deletes the book with title "hamlet", to do that you have to delete the connection between loans table and books table as it has key connection
-- so we select the book id of "hamlet" and use it delete the row from loans table
delete from Loans
where book_id = (SELECT book_id FROM Books WHERE title = "Hamlet");
delete from books where title="Hamlet";

--adds new column genre to books
alter table Books
    add column genre VARCHAR(50);

--selects count of borrowed books, sum of price of all books, avg price of all books
select count(borrower_id) from loans;
select sum(price) from books;
select avg(price) from books;

--selects the details of the books in which the borrower was older than 30 years of age
select * from books --using the book_id selects the details of the book
where book_id in
      (select book_id from loans --using the borrower_id of the person older than 30...here we select the book id of the borrowed book
       where borrower_id in
             (select borrower_id from borrowers
              where timestampdiff(year, dob, CURDATE()) > 30));--using TimeStampDiff to calculate the difference between current date
                                                               -- and dob of the person by only considering the year