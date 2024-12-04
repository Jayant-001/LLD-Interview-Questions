
# Proxy Design Pattern

Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.


### Example 
To illustrate the Proxy Design Pattern I took a example of Employee DAO (Data Access Object) where user will do DB operations using EmployeeDao.

Classes:

- EmployeeDo: Employee data object 
- EmployeeDao: An interface that represents DB operations related to employee.
- EmployeeDaoImpl: Implementation of EmployeeDao
- EmployeeDaoProxy: Act as a proxy between user and EmployeeDaoImpl (evaluates the request before performing the operation).


--------------------------

In Proxy design pattern the proxy object has an object of the actual object that is being called by the client.

It act as a middleware between between client and the actual object being called.

Proxy always delegates the request to next object(it can be another proxy also).

Proxy always implements (extends) the actual Object interface that represents the operations.