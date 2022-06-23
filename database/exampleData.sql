use front_PatrykK;

insert into Department (dep_name) values ("Delivery"), ("Sales"), ("HR"),("Finance"),("Talent Manager"), ("Sales Manager"); 

insert into Employee (emp_name, address, nin, ban, salary, dep_id)
values ('John LastName','New Address 1','11111111111', 'AD1200012030200359100100', 3000.00, 1), 
       ( 'Adam Lastname2','New Address 2','22222222222', 'AE070331234567890123456',  35000.00, 3),
       ( 'Steve LastName3','New Address 3','33333333333', 'PL1201201203020035910100',  4500.00, 5),
       ( 'Maciek Kaczka','New Address 4','12312312312', 'CH9300762011623852957',  60000.50, 6), 
       ( 'Andrew And','New Address 6', '23423423423', 'CZ6508000000192000145399',  150500.00, 4), 
       ( 'Michael Sans','New Address 7', '34534534534','DJ2100010000000154000100186',  90000.00, 1),
       ( "Joe",'New Address 8', "12345678901", "PL1234567890123456789012345678901",  4500.00,1), 
       ( "Jeff",'New Address 9', "09876543210", "PL4209876543210987654321098765321",  4600.00, 2), 
       ( "Bob",'New Address 10', "13579246801", "GB1231231231231231231231231231231",  4200.00, 2);

insert into Project (prj_name)
 values ("New project 1"), ("New project 2"), ("New project 3"), ("New project 4"), ("New project 5"), ("New project 6"), ("New project 7"), ("New project 8"), ("New project 9"), ("New project 10");

insert into Sales_Employee (emp_id, com_rate, sal_rate) values (8, 0.07, 5000), (9,0.14, 10000);

insert into Employee_Project (emp_id, prj_id) values (1, 1), (1, 2), (7, 5), (6, 3), (8, 3), (9, 6);