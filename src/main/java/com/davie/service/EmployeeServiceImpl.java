package com.davie.service;

import com.davie.dao.EmployeeDao;
import com.davie.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Davie on 5/25/2019.
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public Employee findById(int id) {
        return dao.findById(id);
    }

    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        Employee entity = dao.findById(employee.getId());
        if(entity!=null){
            entity.setName(employee.getName());
            entity.setJoiningDate(employee.getJoiningDate());
            entity.setEmploymentnumber(employee.getEmploymentnumber());
            entity.setMiddle(employee.getMiddle());
            entity.setSurname(employee.getSurname());
            entity.setAddress(employee.getAddress());
            entity.setContracttype(employee.getContracttype());
            entity.setContractSignDate(employee.getContractSignDate());

        }
    }

    public void deleteEmployeeBySsn(String employmentnumber) {
        dao.deleteEmployeeBySsn(employmentnumber);
    }

    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

    public Employee findEmployeeBySsn(String employmentnumber) {
        return dao.findEmployeeBySsn(employmentnumber);
    }

    public boolean isEmployeeSsnUnique(Integer id, String employmentnumber) {
        Employee employee = findEmployeeBySsn(employmentnumber);
        return ( employee == null || ((id != null) && (employee.getId() == id)));
    }
}
