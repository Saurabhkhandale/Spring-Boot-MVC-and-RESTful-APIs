package com.codingShuttle.Spring.Boot.MVC.and.RESTful.APIs.demo.repositories;

import com.codingShuttle.Spring.Boot.MVC.and.RESTful.APIs.demo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
   
}
