package com.davie.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by Davie on 5/25/2019.
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=50)
    @Column(name = "FIRST_NAME", nullable = false)
    private String name;


    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "JOINING_DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningDate;

    @NotEmpty
    @Column(name = "EMPLOYMENT_NUMBER", unique=true, nullable = false)
    private String employmentnumber;

    @Size(min=3, max=50)
    @Column(name = "MIDDLE_NAME", nullable = false)
    private String middle;

    @Size(min=3, max=50)
    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Size(min=3, max=50)
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Size(min=3, max=50)
    @Column(name = "CONTRACT_TYPE", nullable = false)
    private String contracttype;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "CONTRACT_SIGN_DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate contractSignDate;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getEmploymentnumber() {
        return employmentnumber;
    }

    public void setEmploymentnumber(String employmentnumber) {
        this.employmentnumber = employmentnumber;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContracttype() {
        return contracttype;
    }

    public void setContracttype(String contracttype) {
        this.contracttype = contracttype;
    }

    public LocalDate getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(LocalDate contractSignDate) {
        this.contractSignDate = contractSignDate;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((employmentnumber == null) ? 0 : employmentnumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (employmentnumber == null) {
            if (other.employmentnumber != null)
                return false;
        } else if (!employmentnumber.equals(other.employmentnumber))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name = " + name + " , joiningDate="
                + joiningDate + ", employmentnumber = "  + employmentnumber + ", middle = " + middle + " , surname = " + surname + " , address = " + address + " , contracttype = " + contracttype + "" +
                " , contractSignDate = " + contractSignDate + "]";
    }
}
