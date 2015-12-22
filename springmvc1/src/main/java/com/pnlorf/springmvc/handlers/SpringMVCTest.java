package com.pnlorf.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
