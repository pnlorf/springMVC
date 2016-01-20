package com.pnlorf.springmvc.converters;

import com.pnlorf.springmvc.crud.entities.Department;
import com.pnlorf.springmvc.crud.entities.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Description:what's the use of this class?
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/1/13.
 */
@Component
public class EmployeeConvert implements Converter<String, Employee> {
    @Override
    public Employee convert(String source) {
        if (source != null) {
            String[] values = source.split("-");
            if (values != null && values.length == 4) {
                String lastName = values[0];
                String email = values[1];
                Integer gender = Integer.valueOf(values[2]);
                Department department = new Department();
                department.setId(Integer.parseInt(values[3]));

                Employee employee = new Employee(null, lastName, email, gender, department);
                System.out.println(source + "--converter--" + employee);
                return employee;
            }
        }
        return null;
    }
}
