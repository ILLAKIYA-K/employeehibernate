// Write your code here

package com.example.employee.repository;

import java.util.*;

import com.example.employee.model.Employee;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployee();

    void delEmployee(int employeeId);

    Employee getEmployeebyId(int employeeId);

    Employee addEmployee(Employee so);

    Employee updateEmployee(int employeeId, Employee son);
}