package com.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.Dao.EmployeeDao;
import com.main.Entity.Employee;

import jakarta.transaction.Transactional;


@Service
public class EmployeeServiceImpl implements Employeeservice{


    private EmployeeDao daoobj;

    public EmployeeServiceImpl(EmployeeDao daoobj)
    {
        this.daoobj=daoobj;
    }

    @Override
    public List<Employee> servicefindAll() {
       
        return daoobj.findAll();
    }

    @Override
    public Employee serviceFindbyId(int i) {
        return daoobj.findbyId(i);
    }

    @Override
    @Transactional
    public void serviceupdateEmployee(int id, String parameter, String value) {
        daoobj.updateEmployee(id, parameter, value);
    }

}
