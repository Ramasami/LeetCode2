# Write your MySQL query statement below
select emp.name as Employee
from employee man
    inner join employee emp on emp.managerId = man.id
where emp.salary > man.salary;