package com.codingShuttle.Spring.Boot.MVC.and.RESTful.APIs.demo.controllers;

import com.codingShuttle.Spring.Boot.MVC.and.RESTful.APIs.demo.dto.EmployeeDTO;
import com.codingShuttle.Spring.Boot.MVC.and.RESTful.APIs.demo.entities.EmployeeEntity;
import com.codingShuttle.Spring.Boot.MVC.and.RESTful.APIs.demo.repositories.EmployeeRepository;
import com.codingShuttle.Spring.Boot.MVC.and.RESTful.APIs.demo.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age
            , @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }


    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);
    }


    @PutMapping(path = "/{employeeId}")
    EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
        return employeeService.updateEmployeeById(employeeDTO, employeeId);
    }

    @DeleteMapping(path = "/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeDTO updatePartialEmployeeById(
            @PathVariable Long employeeId,
            @RequestBody Map<String, Object> updates) {

        return employeeService.updatePartialEmployeeById(employeeId, updates);
    }

}
