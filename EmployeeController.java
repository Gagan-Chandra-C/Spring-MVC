package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/displayAll")
    public List<Employee> displayAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/display/{id}")
    public Employee displayById(@PathVariable String id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
