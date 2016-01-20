package com.pnlorf.springmvc.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Description:自定义View的HelloWorld
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/1/4.
 */
@Component
public class HelloView implements View {

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        response.getWriter().print("Hello view, time:  " + new Date());
    }
}
