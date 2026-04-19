package com.main.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.main.Entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager Entmanager;

    public EmployeeDaoImpl(EntityManager Entmanager)
    {
        this.Entmanager = Entmanager;
    }

    @Override
    public List<Employee> findAll() {
        
        List<Employee> employeeList = new ArrayList<>();
        employeeList = Entmanager.createQuery("Select e from Employee e").getResultList();
        return employeeList;
    }

    

}
