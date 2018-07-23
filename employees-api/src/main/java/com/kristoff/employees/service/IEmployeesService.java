package com.kristoff.employees.service;

import com.kristoff.employees.vo.EmployeeVO;

import java.util.List;

public interface IEmployeesService {
    List<EmployeeVO> findEmployeeList(EmployeeVO employeeVO, Integer currentPage, Integer pageSize);

    void addEmployee(EmployeeVO employeeVO);

    void updateEmployee(EmployeeVO employeeVO);

    void deleteEmployee(String empNo);
}
