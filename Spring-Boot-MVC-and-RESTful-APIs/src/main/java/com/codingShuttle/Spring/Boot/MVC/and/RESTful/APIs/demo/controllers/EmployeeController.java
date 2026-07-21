package com.codingShuttle.Spring.Boot.MVC.and.RESTful.APIs.demo.controllers;

import com.codingShuttle.Spring.Boot.MVC.and.RESTful.APIs.demo.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {


    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
        return new EmployeeDTO(employeeId, "SaurabhKhandale", "saurabh@gmail.com", 24, LocalDate.of(2024, 11, 29), true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age
            , @RequestParam(required = false) String sortBy) {
        return "Hii age is: " + age + " " + sortBy;
    }


    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(108L);
        return inputEmployee;
    }


    @PutMapping
    String updateEmployeeById() {
        return "Hello from Put";
    }
}
