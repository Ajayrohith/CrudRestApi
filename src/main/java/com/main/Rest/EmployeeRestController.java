package com.main.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Dao.EmployeeDao;
import com.main.Entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDao daoobj;

    public EmployeeRestController(EmployeeDao daoobj)
    {
        this.daoobj = daoobj;
    }

    @GetMapping("/employees")
    public List<Employee> returnEmployees()
    {
        return daoobj.findAll();

    }
}
