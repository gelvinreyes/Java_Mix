package com.h2_example.api.service;

import com.h2_example.api.model.Employee;
import com.h2_example.api.repository.EmployeeRepository;
import java.util.List;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ConduentEmployeeService implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee findById(int id) throws NotFoundException {
        return null;
    }

    @Override
    public List<Employee> findAllOrdered() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
