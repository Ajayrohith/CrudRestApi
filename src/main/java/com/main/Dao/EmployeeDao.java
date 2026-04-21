package com.main.Dao;
import java.util.List;

import com.main.Entity.*;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findbyId(int i);

    public void updateEmployee(int id, String parameter, String value);

    public Employee Save(Employee emp);

}
