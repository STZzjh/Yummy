package com.zjh.yummy.common.web;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component
public class StartupListener implements ServletContextAware {

    @Override
    public void setServletContext(ServletContext servletContext) {
        String mainName = "Yummy";
        Seo seo = new Seo();
        seo.setMainName(mainName);
        servletContext.setAttribute("seo",seo);
    }

}
