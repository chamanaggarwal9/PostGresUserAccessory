package com.example.postGresAcc.controller;

import com.example.postGresAcc.entity.Employee;
import com.example.postGresAcc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/employeeSave")
    public void savee(@RequestBody Employee employee)
    {
        employeeService.save(employee);
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<Employee> findbyId(@PathVariable("userId") int userId)
    {
        if (employeeService.existsById(userId))
        {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(userId));
        }
        else
        {
            return new ResponseEntity<>(
                    (Employee) null, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/update")
    public void updateUser(@RequestBody Employee employee)
    {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping(value = "{userId}")
    public void deletebyUserId(@PathVariable("userId") int userId)
    {
        if (employeeService.existsById(userId))
        {
            employeeService.deleteById(userId);
        }
        else
        {
            new ResponseEntity<>(
                    (Employee) null, HttpStatus.OK);
        }
    }

}

