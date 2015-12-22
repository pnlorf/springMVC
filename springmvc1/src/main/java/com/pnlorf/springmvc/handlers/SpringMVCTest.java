package com.pnlorf.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:@RequestMapping修饰class
 *
 * @author PNLORF
 * @version 1.0
 * @since 2015/12/22.
 */
@RequestMapping("springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

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
    @RequestMapping(value = "/testParamsAndHeaders", params = {"username", "age!=10"}, headers = {"Accept-Language=zh-CN,zh;q=0.8"})
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
