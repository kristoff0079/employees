package com.kristoff.employees.dao;

import com.kristoff.employees.vo.EmployeeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Employees DAO
 * @author Kristoff
 */
public interface IEmployeesDao {
    List<EmployeeVO> findEmployeeList(EmployeeVO employeeVO);

    void insertEmployee(EmployeeVO employeeVO);

    void updateEmployee(EmployeeVO employeeVO);

    void deleteEmployee(@Param("empNo") String empNo);
}
