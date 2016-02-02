package com.pnlorf.springmvc.test;

import com.pnlorf.springmvc.crud.dao.EmployeeDao;
import com.pnlorf.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

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

    @Autowired
    private ResourceBundleMessageSource messageSource;

    /**
     * 1.在方法@ExceptionHandler方法的入参中可以加入Exception类型的参数，该参数即对应发生的异常对象
     * 2.在方法@ExceptionHandler方法的入参中不能传入Map，若希望把异常信息传递到页面上，需要使用ModelAndView作为返回值
     * 3.@ExceptionHandler方法标记的异常有优先级的问题。
     * 4.@ControllerAdvice:如果在当前Handler中找不到 @ExceptionHandler修饰的方法来处理当前方法出现的异常，
     * 则将去@ControllerAdvice标记的类中查找@ExceptionHandler标记的方法来处理异常。
     *
     * @param ex
     * @return
     */
/*    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex) {
        System.out.println("出异常了: " + ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        return mv;
    }

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView handleArithmeticException2(Exception ex) {
        System.out.println("[出异常了]: " + ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        return mv;
    }*/
    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i) {
        System.out.println("result: " + (10 / i));
        return "success";
    }

    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc,
                                 @RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println("desc: " + desc);
        System.out.println("OriginalFilename: " + multipartFile.getOriginalFilename());
        System.out.println("InputStream: " + multipartFile.getInputStream());
        return "success";
    }

    @RequestMapping("/i18n")
    public String testI18n(Locale locale) {
        String val = messageSource.getMessage("i18n.user", null, locale);
        System.out.println(val);
        return "i18n";
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/files/data.txt");
        body = new byte[in.available()];
        in.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=data.txt");

        HttpStatus httpStatus = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, headers, httpStatus);
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println(body);
        return "helloworld! " + new Date();
    }


    @RequestMapping("/testConversionServiceConverter")
    public String testConverter(@RequestParam("employee") Employee employee) {
        System.out.println("save: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson() {
        return employeeDao.getAll();
    }
}
