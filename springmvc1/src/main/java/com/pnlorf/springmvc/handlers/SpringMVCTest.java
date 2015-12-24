package com.pnlorf.springmvc.handlers;

import com.pnlorf.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
//@SessionAttributes(names = {"user"}, types = {String.class})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

    /**
     * 有@ModelAttribute标记的方法，会在每个目标方法执行之前被SpringMVC调用
     *
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        Map<String, Object> map) {
        System.out.println("ModelAttribute Method");
        if (id != null) {
            // 模拟从数据库中获取对象
            User user = new User(1, "Tom", "123456", "tom@163.com", 24);
            System.out.println("从数据库中获取一个对象： " + user);
            map.put("user", user);
        }
    }

    /**
     * 运行流程：
     * 1. 执行@ModelAttribute注解修饰的方法：从数据库中取出对象，把对象放入到Map中。键为：user
     * 2. SpringMVC从Map中取出User对象，并把表单的请求参数赋给该User对象的对应属性。
     * 3. SpringMVC把上述对象传入目标方法的参数中。
     *
     * 注意：在@ModelAttribute修饰的方法中，放入到Map时的键需要和目标方法入参类型的第一个字母小写的字符串一致！
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("修改：" + user);
        return SUCCESS;
    }

    /**
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是value属性值)，
     * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中（实际上使用的是types属性值）
     * 猜测其中的names属性和value属性作用相同
     * <p>
     * 注意：@SessionAttributes注解只能放在类的上面修饰类，而不可以放到方法上修饰方法
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        User user = new User("Tom", "123456", "tom@163.com", 25);
        map.put("user", user);
        map.put("school", "nec");
        return SUCCESS;
    }

    /**
     * 处理模型数据的第二种方式：目标方法可以添加Map(实际上也可以是Model类型或者ModelMap类型)类型的参数。
     *
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
        return SUCCESS;
    }

    /**
     * 处理模型数据的第一种方法：
     * 目标方法的返回值可以是ModelAndView类型。
     * 其中可以包含视图和模型信息。
     * Spring MVC会把ModelAndView的model中数据放入到request的域对象中。
     *
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
     * Rest风格的URL
     * 以CRUD为例：
     * 新增：/order POST
     * 修改：/order/1 PUT      update?id=1
     * 获取：/order/1 GET      get?id=1
     * 删除：/order/1 DELETE   delete?id=1
     * <p>
     * 如何发送PUT请求和DELETE请求呢？
     * 1. 需要配置HiddenHttpMethodFilter
     * 2. 需要发送POST请求
     * 3. 需要在POST请求时携带一个隐藏域name="_method"的隐藏域，值为DELETE或者PUT
     * <p>
     * 在SpringMVC的目标方法中如何得到id呢？
     * 使用@PathVariable注解
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("test Rest Put: " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println("test Rest Delete: " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRest() {
        System.out.println("test Rest POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRest(@PathVariable Integer id) {
        System.out.println("test Rest GET: " + id);
        return SUCCESS;
    }

    /**
     * @PathVariable 可以映射URL中的占位符到目标方法的参数中。
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable： " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /**
     * 了解：可以使用params和headers来更加精确的映射请求。params和headers支持简单的表达式
     *
     * @return
     */
    @RequestMapping(value = "/testParamsAndHeaders", params = {"username", "age!=10"}, headers =
            {"Accept-Language=zh-CN,zh;q=0.8"})
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * 常用： 使用method属性来指定请求方式
     *
     * @return
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
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
