use front_PatrykK;

create table Department(
	dep_id smallint primary key auto_increment,
    dep_name varchar(30) not null
);

create table Employee(
	emp_id smallint primary key auto_increment,
    emp_name varchar(50) not null,
    address varchar(100) not null,
    nin varchar(11) not null unique,
    ban varchar(34) not null unique,
    salary decimal(11,2) not null,
    dep_id smallint not null,
    foreign key (dep_id) references Department(dep_id)
);

create table Sales_Employee(
	sal_id smallint primary key auto_increment,
    emp_id smallint,
    com_rate decimal(5,2) not null,
    sal_rate decimal(7,2) not null,
    foreign key (emp_id)  references Employee(emp_id)
);

create table Project(
	prj_id smallint primary key auto_increment,
    prj_name varchar(100) not null
);

create table Employee_Project(
	emp_id smallint,
    prj_id smallint,
    foreign key (emp_id) references Employee(emp_id),
    foreign key (prj_id) references Project(prj_id)
);

create table User(
	login varchar(100) primary key,
    `password` varchar(100) not null,
    dep_id smallint not null,
    foreign key (dep_id) references Department(dep_id)
    
);
