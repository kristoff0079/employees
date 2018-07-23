package com.kristoff.employees.service.impl;

import com.github.pagehelper.PageHelper;
import com.kristoff.employees.dao.IEmployeesDao;
import com.kristoff.employees.service.IEmployeesService;
import com.kristoff.employees.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements IEmployeesService  {

    @Autowired
    private IEmployeesDao employeesDao;

    @Override
    public List<EmployeeVO> findEmployeeList(EmployeeVO employeeVO, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return employeesDao.findEmployeeList(employeeVO);
    }

    @Override
    public void addEmployee(EmployeeVO employeeVO) {
        employeesDao.insertEmployee(employeeVO);
    }

    @Override
    public void updateEmployee(EmployeeVO employeeVO) {
        employeesDao.updateEmployee(employeeVO);
    }

    @Override
    public void deleteEmployee(String empNo) {
        employeesDao.deleteEmployee(empNo);
    }
}
