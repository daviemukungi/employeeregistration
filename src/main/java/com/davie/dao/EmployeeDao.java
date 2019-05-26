package com.davie.dao;

import com.davie.model.Employee;

import java.util.List;

/**
 * Created by Davie on 5/25/2019.
 */
public interface EmployeeDao {
    Employee findById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeBySsn(String employmentnumber);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String employmentnumber);
}
