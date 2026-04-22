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

    @Override
    public Employee findbyId(int i) {

          return  Entmanager.find(Employee.class,i);
    }

    @Override
    public void updateEmployee(int id, String parameter, String value) {
        
        Employee obj = Entmanager.find(Employee.class,id);
        if(parameter.equalsIgnoreCase("firstname"))
        {
            obj.setFirstName(value);
        }
        else if (parameter.equalsIgnoreCase("lastname"))
        {
            obj.setLastName(value);
        }
        else if (parameter.equalsIgnoreCase("dept"))
        {
            obj.setDepartment(value);
        }
        Entmanager.merge(obj);

    }

    @Override
    public Employee Save(Employee emp) {
        

        ///The below merge function returns the updated object 
        /// for Example the emp initially contains only firstname,lastname and dept
        /// but after merge it will return the object along with the id generated
        Employee  updatedobj = Entmanager.merge(emp);
        return updatedobj;
        
    }

    @Override
    public void removeEmployee(int id) {
        
        Employee emp = Entmanager.find(Employee.class, id);
        Entmanager.remove(emp);
    }

    

}
