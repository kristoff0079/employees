package com.kristoff.employees.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kristoff.common.utils.Constants;

import java.io.Serializable;
import java.util.Date;

public class EmployeeVO implements Serializable {
    private Integer empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private String hireDate;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    @JsonFormat(pattern = Constants.DATE_FORMAT)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonFormat(pattern = Constants.DATE_FORMAT)
    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}
