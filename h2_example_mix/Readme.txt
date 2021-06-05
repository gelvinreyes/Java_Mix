# Getting Started

Project Created by Gelvin Reyes Jun2021

Rest API project using Spring and java11

This project implements CRUD:

For saving an employee (use json object in the body)
method post:
/employee
example:
{
    "name":"Gelvin Reyes",
    "dept":"Elinvar-Dev",
    "salary":10000
}

List all employee ordered by name in json package.
method get:
http://localhost:8080/employee

For list an employee by id
method get:
/employee/{id}

Delete an employee by id
method delete:
/employee/{id}

update an employee by id
method post including ID.
{
    "id":1,
    "name":"Gelvin Reyes",
    "dept":"Elinvar-Dev",
    "salary": 10000
}


