package com.h2_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/saveEmployee")
    public String saveEmployee(Employee employee){
        repository.save(employee);
        return "Employee Saved:" + employee.getName();
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAll(){
        return repository.findAll();
    }

    @GetMapping("/getEmployee/{dept}")
    public List<Employee> getEmployeeByDept(@PathVariable String dept){
        return repository.findByDept(dept);

    }


}
