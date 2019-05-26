package com.davie.service;

import com.davie.model.Employee;

import java.util.List;

/**
 * Created by Davie on 5/25/2019.
 */
public interface EmployeeService {

    Employee findById(int id);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeBySsn(String employmentnumber);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String employmentnumber);

    boolean isEmployeeSsnUnique(Integer id, String employmentnumber);

}
