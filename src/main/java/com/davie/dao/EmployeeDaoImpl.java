package com.davie.dao;

import com.davie.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Davie on 5/25/2019.
 */
@Repository("employeeDao")

public class EmployeeDaoImpl  extends AbstractDao<Integer, Employee> implements EmployeeDao {

    public Employee findById(int id) {
        return getByKey(id);
    }

    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    public void deleteEmployeeBySsn(String employmentnumber) {
        Query query = getSession().createSQLQuery("delete from Employee where employment_number = :employmentnumber");
        query.setString("employmentnumber", employmentnumber);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = createEntityCriteria();
        return (List<Employee>) criteria.list();
    }

    public Employee findEmployeeBySsn(String employmentnumber) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("employmentnumber", employmentnumber));
        return (Employee) criteria.uniqueResult();
    }
}
