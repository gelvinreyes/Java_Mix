package com.h2_example.api.service;

import com.h2_example.api.model.Employee;
import com.h2_example.api.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class XeroxEmployeeService implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(final Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findById(final int id) throws NotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()){
            log.error("no se pudo encontrar el empleado");
            throw new NotFoundException("employee not found");
        }
        return employeeOptional.get();
    }

    public List<Employee> findAllOrdered(){
        return  employeeRepository.findAllByOrderByNameAsc();
    }

    public void deleteById(final int id){
        employeeRepository.deleteById(id);
        log.info("employee with id {} was deleted", id);
    }
}
