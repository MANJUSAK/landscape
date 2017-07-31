package com.goodsoft.landscape.config.hibernate.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;

/**
 * hibernate sessionFactory过滤配置
 * 使用当前线程hibernate的session必须配置此过滤器
 * 不然无法正常使用
 * Created by 严彬荣 on 2017/7/19.
 */

@Configuration
public class OpenHibernateSession {

    @Bean
    public FilterRegistrationBean registerFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        OpenSessionInViewFilter filter = new OpenSessionInViewFilter();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("singleSession", "true");
        return registrationBean;
    }
}
