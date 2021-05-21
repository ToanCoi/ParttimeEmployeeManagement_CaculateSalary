create database se_2021;

create table tblEmployee(
	id int,
    name varchar(30) not null,
    phoneNumber varchar(15) not null,
    address varchar(30) not null,
    dateOfBirth date not null,
    gender varchar(10) not null,
    email varchar(30) not null,
    primary key (id)
);

alter table tblemployee auto_increment = 100;

create table tblManger(
	id int,
    username varchar(30) not null,
    password varchar(30) not null,
    primary key (id),
    foreign key (id) references tblEmployee(id)
);

create table tblSalary(
	id int,
    allowance double not null,
    bonus double not null,
    paid bit not null,
    tblManagerid int not null,
    primary key (id),
    foreign key (tblManagerid) references tblmanger(id)
);

create table tblParttimeEmployee(
	id int,
    hourlyWages double not null,
    primary key (id),
    foreign key (id) references tblemployee(id)
);

create table tblshift(
	id int,
    type varchar(10) not null,
    startTime time not null,
    endTime time not null,
    primary key (id)
);

create table tblWorkedShift(
	id int, 
    checkinTime time not null,
    checkoutTime time not null,
    date date not null,
    weeksDay varchar(20) not null,
    coefficientsSalary double not null,
    hourlyWages double not null,
    tblParttimeEmployeeid int not null,
    tblShiftid int not null,
    tblSalaryid int not null,
    primary key (id),
    foreign key (tblParttimeEmployeeid) references tblparttimeemployee(id),
    foreign key (tblShiftid) references tblshift(id),
    foreign key (tblSalaryid) references tblSalary(id)
);