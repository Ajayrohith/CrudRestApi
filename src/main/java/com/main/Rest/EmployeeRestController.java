package com.main.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Entity.Employee;
import com.main.service.Employeeservice;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private Employeeservice EmpService;

    public EmployeeRestController(Employeeservice EmpService)
    {
        this.EmpService = EmpService;
    }

    @GetMapping("/employees")
    public List<Employee> returnEmployees()
    {
        return EmpService.servicefindAll();

    }

    @GetMapping("/employees/{id}")
    public Employee returnEmployeebyId(@PathVariable int id)
    {
        return EmpService.serviceFindbyId(id);
    }

    @PutMapping("/employees/{id}/{parameter}/{value}")
    public void returnupdateEmployee(@PathVariable int id,
                                 @PathVariable String parameter,
                                 @PathVariable String value)
    {
        EmpService.serviceupdateEmployee(id, parameter, value);
    }
}
