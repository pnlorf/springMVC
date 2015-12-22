package com.pnlorf.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:Spring MVC 的HelloWorld
 *
 * @author PNLORF
 * @version 1.0
 * @since 2015/12/22.
 */
@Controller
public class HelloWorld {

    /**
     * 1. 使用@RequestMapping注解来映射请求的URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器，会做如下的解析：
     * 通过前缀prefix+returnValue + 后缀suffix 这样的方式得到实际的物理视图，然后做转发操作
     * <p>
     * /WEB-INF/views/success.jsp
     *
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("Hello, World!");
        return "success";
    }
}
