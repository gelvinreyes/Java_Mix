package com.h2_example.api.service;

import com.h2_example.api.model.Employee;
import java.util.List;
import javassist.NotFoundException;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);
    public Employee findById(final int id) throws NotFoundException;
    public List<Employee> findAllOrdered();
    public void deleteById(final int id);
}
