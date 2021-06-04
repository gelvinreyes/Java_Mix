package com.h2_example.api.repository;

import com.h2_example.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Autowired
    List<Employee> findByDept(String dep);

    List<Employee> findAllByOrderByNameAsc();

    //  List<Employee> findByDept(String dep);


}
