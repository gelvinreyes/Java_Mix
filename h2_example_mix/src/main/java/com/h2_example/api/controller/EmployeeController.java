package com.h2_example.api.controller;

import com.h2_example.api.model.Employee;
import com.h2_example.api.service.EmployeeService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@Slf4j
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody final Employee employee){
        final Employee persisted = employeeService.saveEmployee(employee);
        log.info("guardamos un empleado");
        return new ResponseEntity(persisted, HttpStatus.OK);
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable final int id){
        try {
             Employee found = employeeService.findById(id);
             return new ResponseEntity(found, HttpStatus.OK);
        }
        catch (NotFoundException notFoundException){
            log.error("employee not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.findAllOrdered(), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable final int id){
        employeeService.deleteById(id);
        return new ResponseEntity("Employee with id " + id +" was deleted", HttpStatus.OK);
    }

    @PutMapping("/employee/")
    public ResponseEntity<Employee> updateEmployee(@RequestBody final Employee employee){
        employeeService.updateEmployee(employee);
        return new ResponseEntity(employee, HttpStatus.OK);
    }

}
