package com.pnlorf.springmvc.test;

import com.pnlorf.springmvc.crud.dao.EmployeeDao;
import com.pnlorf.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Description:what's the use of this class?
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/1/13.
 */
@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/testConversionServiceConverter")
    public String testConverter(@RequestParam("employee") Employee employee) {
        System.out.println("save: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }
}
