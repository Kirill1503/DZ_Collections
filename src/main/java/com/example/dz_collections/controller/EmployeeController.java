package com.example.dz_collections.controller;

import com.example.dz_collections.employee.Employee;
import com.example.dz_collections.employeeService.EmployeeService;
import com.example.dz_collections.employee.Employee;
import com.example.dz_collections.employeeService.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstname") String name,
                        @RequestParam("lastname") String surname) {
        return employeeService.addEmployee(name, surname);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstname") String name,
                         @RequestParam("lastname") String surname) {
        return employeeService.findEmployee(name, surname);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstname") String name,
                           @RequestParam("lastname") String surname) {
        return employeeService.removeEmployee(name, surname);
    }
}
