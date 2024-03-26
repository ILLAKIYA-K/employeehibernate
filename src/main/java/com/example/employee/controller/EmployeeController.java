/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here

package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;

@RestController

public class EmployeeController {
    @Autowired
    public EmployeeJpaService ser;

    @DeleteMapping("/employees/{employeeId}")
    public void delEmployee(@PathVariable("employeeId") int employeeId)
    {
        ser.delEmployee(employeeId);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeebyId(@PathVariable("employeeId") int employeeId) {
        return ser.getEmployeebyId(employeeId);
    }

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployee() {
        return ser.getEmployee();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee so) {
        return ser.addEmployee(so);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee son) {
        return ser.updateEmployee(employeeId, son);
    }

}
