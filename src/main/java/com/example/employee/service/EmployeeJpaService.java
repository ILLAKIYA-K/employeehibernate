/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here

package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeJpaRepository;
import com.example.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class EmployeeJpaService implements EmployeeRepository {

    @Autowired
    private EmployeeJpaRepository serv;

    @Override
    public Employee updateEmployee(int employeeId, Employee son) {
        try {
            Employee f = serv.findById(employeeId).get();
            if (son.getEmployeeName() != null) {
                f.setEmployeeName(son.getEmployeeName());
            }
            if (son.getEmail() != null) {
                f.setEmail(son.getEmail());
            }
            if (son.getDepartment() != null) {
                f.setDepartment(son.getDepartment());
            }

            serv.save(f);
            return f;
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArrayList<Employee> getEmployee() {
        List<Employee> EmployeeColl = serv.findAll();
        ArrayList<Employee> arr = new ArrayList<>(EmployeeColl);

        return arr;
    }

    @Override
    public Employee addEmployee(Employee so) {
        serv.save(so);
        return so;
    }

    @Override
    public Employee getEmployeebyId(int employeeId) {
        try {
            Employee ks = serv.findById(employeeId).get();
            return ks;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delEmployee(int employeeId) {
        try {

            serv.deleteById(employeeId);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}
