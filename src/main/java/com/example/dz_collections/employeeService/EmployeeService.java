package com.example.dz_collections.employeeService;

import com.example.dz_collections.employee.Employee;
import com.example.dz_collections.exception.EmployeeAlreadyAddedException;
import com.example.dz_collections.exception.EmployeeNotFoundException;
import com.example.dz_collections.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        String key = getKey(name, surname);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    public Employee findEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }


    public Employee removeEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    private String getKey(String name, String surname) {
        return name + " " + surname;
    }
}
