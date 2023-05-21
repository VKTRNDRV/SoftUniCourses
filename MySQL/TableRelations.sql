-- TABLE RELATIONS EXERCISES -- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- 1. One-To-One Relationship @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
create table `passports`(
`passport_id` int primary key auto_increment,
`passport_number` varchar(100) unique
);

INSERT INTO `passports` (`passport_id`, `passport_number`)
VALUES
    (101, 'N34FG21B'),
    (102, 'K65LO4R7'),
    (103, 'ZE657QP2');



create table `people` (
`person_id` int primary key auto_increment,
`first_name` varchar(100),
`salary` decimal(8, 2),
`passport_id` int unique,
constraint fk_passport_id foreign key (`passport_id`) references `passports`(`passport_id`)
);

INSERT INTO `people` (`person_id`, `first_name`, `salary`, `passport_id`)
VALUES
    (1, 'Roberto', 43300.00, 102),
    (2, 'Tom', 56100.00, 103),
    (3, 'Yana', 60200.00, 101);
    
    
    
-- 2. One-To-Many Relationship @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
create table manufacturers (
manufacturer_id int primary key auto_increment,
`name` varchar(100),
established_on date
);

INSERT INTO manufacturers (manufacturer_id, `name`, established_on)
VALUES
    (1, 'BMW', '1916-03-01'),
    (2, 'Tesla', '2003-01-01'),
    (3, 'Lada', '1966-05-01');
    
    
    
create table models(
	model_id int primary key auto_increment,
    `name` varchar(100),
    manufacturer_id int,
constraint fk_m_id foreign key
	(manufacturer_id) references manufacturers(manufacturer_id)
);

INSERT INTO models (model_id, name, manufacturer_id)
VALUES
    (101, 'X1', 1),
    (102, 'i6', 1),
    (103, 'Model S', 2),
    (104, 'Model X', 2),
    (105, 'Model 3', 2),
    (106, 'Nova', 3);



-- 3. Many-To-Many Relationship @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
create table students(
	student_id int primary key auto_increment,
    `name` varchar(100) not null
);

insert into students
values
	(1, 'Mila'),
    (2, 'Toni'),
    (3, 'Ron');
    
    

create table exams(
	exam_id int primary key auto_increment,
    `name` varchar(100) not null
);

insert into exams
values
	(101, 'Spring MVC'),
    (102, 'Neo4j'),
    (103, 'Oracle 11g');
    


create table students_exams(
	student_id int not null,
    exam_id int not null,
constraint fk_s_id foreign key (student_id) references students(student_id),
constraint fk_e_id foreign key (exam_id) references exams(exam_id)
);

insert into students_exams
values
	(1, 101),
    (1, 102),
    (2, 101),
    (3, 103),
    (2, 102),
    (2, 103);
    
    
    
-- 4. Self-Referencing @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
create table teachers(
	teacher_id int primary key auto_increment,
    `name` varchar(50) not null,
    manager_id int,
constraint fk_mngr_id foreign key (manager_id) references teachers(teacher_id)
);

insert into teachers (teacher_id, `name`, manager_id)
values
	(101, 'John', null),
    (105, 'Mark', 101),
    (106, 'Greta', 101),
    (102, 'Maya', 106),
    (103, 'Silvia', 106),
    (104, 'Ted', 105);
    
    
    
-- 5. Online Store Database @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
create table cities(
	city_id int(11) primary key auto_increment,
    `name` varchar(50) not null
);

create table customers(
	customer_id int primary key auto_increment,
    `name` varchar(50) not null,
    birthday date,
    city_id int(11),
constraint fk_city_id foreign key (city_id) references cities(city_id)
);

create table orders(
	order_id int(11) primary key auto_increment,
    customer_id int(11),
constraint fk_customer_id foreign key (customer_id) references customers(customer_id)
);

create table item_types(
	item_type_id int(11) primary key auto_increment,
    name varchar(50)
);

create table items(
	item_id int(11) primary key auto_increment,
    `name` varchar(50),
    item_type_id int(11),
constraint fk_i_t foreign key (item_type_id) references item_types(item_type_id)
);

create table order_items(
	order_id int(11) not null,
    item_id int(11),
constraint pk_o_i primary key (order_id, item_id),
constraint fk_o_id foreign key (order_id) references orders(order_id),
constraint fk_i_id foreign key (item_id) references items(item_id)
);



# 6. University Database @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
CREATE TABLE `subjects` (
    `subject_id` INT PRIMARY KEY AUTO_INCREMENT,
    `subject_name` VARCHAR(50) NULL
);
 
CREATE TABLE `majors` (
    `major_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NULL
);
 
CREATE TABLE `students` (
    `student_id` INT PRIMARY KEY AUTO_INCREMENT,
    `student_number` VARCHAR(12) UNIQUE NOT NULL,
    `student_name` VARCHAR(50) NOT NULL,
    `major_id` INT,
    CONSTRAINT fk_student_major
    FOREIGN KEY (`major_id`)
    REFERENCES `majors`(`major_id`)
);
 
CREATE TABLE `payments` (
    `payment_id` INT PRIMARY KEY AUTO_INCREMENT,
    `payment_date` DATE NULL,
    `payment_amount` DECIMAL(8, 2),
    `student_id` INT NULL,
    CONSTRAINT fk_payment_student
    FOREIGN KEY (`student_id`)
    REFERENCES `students` (`student_id`)
);
 
CREATE TABLE `agenda` (
    `student_id` INT NOT NULL,
    `subject_id` INT,
    CONSTRAINT pk
    PRIMARY KEY(`student_id`, `subject_id`),
    CONSTRAINT fk_student
    FOREIGN KEY (`student_id`)
    REFERENCES `students` (`student_id`), 
    CONSTRAINT fk_item
    FOREIGN KEY (`subject_id`)
    REFERENCES `subjects` (`subject_id`)
);



-- 9. Peaks in Rila @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select m.mountain_range, p.peak_name, p.elevation as peak_elevation
from mountains as m 
	join peaks as p on m.id = p.mountain_id
where m.mountain_range = 'Rila'
order by peak_elevation desc;









