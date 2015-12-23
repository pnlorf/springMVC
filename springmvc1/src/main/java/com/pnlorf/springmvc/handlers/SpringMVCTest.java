package com.pnlorf.springmvc.handlers;

import com.pnlorf.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Description:@RequestMapping修饰class
 *
 * @author PNLORF
 * @version 1.0
 * @since 2015/12/22.
 */
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

    /**
     * 处理模型数据的第二种方式：目标方法可以添加Map(实际上也可以是Model类型或者ModelMap类型)类型的参数。
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map ){
        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
        return SUCCESS;
    }

    /**
     * 处理模型数据的第一种方法：
     * 目标方法的返回值可以是ModelAndView类型。
     * 其中可以包含视图和模型信息。
     * Spring MVC会把ModelAndView的model中数据放入到request的域对象中。
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        // 添加模型数据到ModelAndView中
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }


    /**
     * 可以使用Servlet原生的API作为目标方法的参数
     * 具体支持以下类型：
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * java.security.Principal
     * Locale
     * InputStream
     * OutputStream
     * Reader
     * Writer
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("testServletAPI, " + request + " ,  " + response);
        return SUCCESS;
    }

    /**
     * 使用Pojo作为参数
     * Spring MVC会按照请求参数名和POJO属性名进行自动匹配，
     * 自动为该独享填充属性值。支持级联属性。如：dept.deptId、dept.address.tel等
     *
     * @param user
     * @return
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo: " + user);
        return SUCCESS;
    }

    /**
     * @param sessionId
     * @return
     * @CookieValue： 映射一个Cookie值。属性同@RequestParam
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("testCookieValue: sessionId: " + sessionId);
        return SUCCESS;
    }

    /**
     * 用法同@RequestParam，映射请求头信息
     *
     * @param al
     * @return
     */
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al) {
        System.out.println("testRequestHeader, " + al);
        return SUCCESS;
    }

    /**
     * @param username
     * @param age
     * @return
     * @RequestParam 来映射请求参数。
     * value ：值即为请求参数的参数名
     * required：该请求参数是否必须。默认值是true
     * defaultValue： 请求参数的默认值
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam, username: " + username + ", age: " + age);
        return SUCCESS;
    }

    /**
     * 1. @RequestMapping除了修饰方法，还可以修饰类class
     * 2.
     * 1）.类定义处：提供初步请求映射信息。相对于WEB应用的根目录
     * 2）.方法处：提供进一步细分映射信息。
     * 相对于类定义处URL。若类定义处未标注@RequestMapping，则方法处标记的URL相对于WEB应用的根目录。
     *
     * @return
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}
