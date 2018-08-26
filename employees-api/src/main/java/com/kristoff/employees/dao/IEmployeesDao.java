package com.kristoff.employees.dao;

import com.kristoff.employees.vo.EmployeeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Employees DAO
 * @author Kristoff
 */
public interface IEmployeesDao {
    /**
     * 查询员工列表
     * @param employeeVO
     * @return
     */
    List<EmployeeVO> findEmployeeList(EmployeeVO employeeVO);

    /**
     * 插入员工信息
     * @param employeeVO
     */
    void insertEmployee(EmployeeVO employeeVO);

    /**
     * 更新员工信息
     * @param employeeVO
     */
    void updateEmployee(EmployeeVO employeeVO);

    /**
     * 删除员工信息
     * @param empNo
     */
    void deleteEmployee(@Param("empNo") String empNo);
}
