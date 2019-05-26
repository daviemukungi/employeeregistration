package com.davie.controller;

import com.davie.model.Employee;
import com.davie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by Davie on 5/25/2019.
 */
@Controller
@RequestMapping("/")
public class AppController {
    @Autowired
    EmployeeService service;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {

        List<Employee> employees = service.findAllEmployees();
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result,
                               ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getEmploymentnumber())){
            FieldError ssnError =new FieldError("employee","employmentnumber",messageSource.getMessage("non.unique.employmentnumber", new String[]{employee.getEmploymentnumber()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }

        service.saveEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
        return "success";
    }

    @RequestMapping(value = { "/edit-{employmentnumber}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String employmentnumber, ModelMap model) {
        Employee employee = service.findEmployeeBySsn(employmentnumber);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }

    @RequestMapping(value = { "/edit-{employmentnumber}-employee" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
                                 ModelMap model, @PathVariable String employmentnumber) {

        if (result.hasErrors()) {
            return "registration";
        }

        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getEmploymentnumber())){
            FieldError ssnError =new FieldError("employee","employmentnumber",messageSource.getMessage("non.unique.employmentnumber", new String[]{employee.getEmploymentnumber()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }

        service.updateEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getName()	+ " updated successfully");
        return "success";
    }

    @RequestMapping(value = { "/delete-{employmentnumber}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String employmentnumber) {
        service.deleteEmployeeBySsn(employmentnumber);
        return "redirect:/list";
    }

}
