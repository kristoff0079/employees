package com.kristoff.employees.web;

import com.github.pagehelper.PageInfo;
import com.kristoff.common.vo.BasicResponseVO;
import com.kristoff.employees.service.IEmployeesService;
import com.kristoff.employees.vo.EmployeeVO;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(path = "/emp")
//@CrossOrigin
public class EmployeesController {

    private static final Logger LOGGER = Logger.getLogger(EmployeesController.class);

    @Autowired
    private IEmployeesService employeesService;

    @RequiresPermissions("emp:findEmployeeList")
    @ApiOperation(value = "查询员工列表", notes = "查询员工列表")
    @RequestMapping(path = "/findEmployeeList",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public BasicResponseVO findEmployeeList(EmployeeVO emp,
                                            @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
                                            @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage) {

        Locale locale = LocaleContextHolder.getLocale();

        LOGGER.info("locale is " + locale);

        try {

            List<EmployeeVO> empList = employeesService.findEmployeeList(emp, currentPage, pageSize);
            if (empList == null | empList.isEmpty()) {
                return BasicResponseVO.nodata();
            }

            PageInfo<EmployeeVO> pageInfo = new PageInfo<>(empList);

            return BasicResponseVO.ok(pageInfo);
        } catch (Exception e) {
            LOGGER.error("findEmployeeList error", e);
            return BasicResponseVO.error(null, e.getMessage());
        }
    }

    @ApiOperation(value = "添加员工", notes = "添加员工")
    @RequestMapping(path = "/addEmployee",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST)
    @ResponseBody
    public BasicResponseVO addEmployee(@RequestBody EmployeeVO emp) {
        try {
            employeesService.addEmployee(emp);
            return BasicResponseVO.ok();
        } catch (Exception e) {
            LOGGER.error("addEmployee error", e);
            return BasicResponseVO.error(null, e.getMessage());
        }
    }

    @ApiOperation(value = "更新员工信息", notes = "更新员工信息")
    @RequestMapping(path = "/updateEmployee",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST)
    @ResponseBody
    public BasicResponseVO updateEmployee(@RequestBody EmployeeVO emp) {
        try {
            employeesService.updateEmployee(emp);
            return BasicResponseVO.ok();
        } catch (Exception e) {
            LOGGER.error("addEmployee error", e);
            return BasicResponseVO.error(null, e.getMessage());
        }
    }

    @ApiOperation(value = "删除员工", notes = "删除员工")
    @RequestMapping(path = "/deleteEmployee",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public BasicResponseVO deleteEmployee(@RequestParam("empNo") String empNo) {
        try {
            employeesService.deleteEmployee(empNo);
            return BasicResponseVO.ok();
        } catch (Exception e) {
            LOGGER.error("deleteEmployee error", e);
            return BasicResponseVO.error(null, e.getMessage());
        }
    }
}
