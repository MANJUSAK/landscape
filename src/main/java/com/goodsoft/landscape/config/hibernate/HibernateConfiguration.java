package com.goodsoft.landscape.config.hibernate;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

/**
 * hibernate  sessionFactory配置
 * 数据库事务配置
 * <p>
 * Created by 严彬荣 on 2017/7/19.
 */
@Configuration
public class HibernateConfiguration {
    @Value("${spring.hibernate.packageScan}")
    private String packageScan;
    @Value("${spring.hibernate.dialect}")
    private String dialect;
    @Value("${spring.show-sql}")
    private String showSql;
    @Value("${spring.hibernate.format_sql}")
    private String formatSql;
    @Value("${spring.hibernate.use_sql_comments}")
    private String useSqlComments;
    @Value("${spring.hibernate.ddl-auto}")
    private String ddlAuto;

    //配置sessionFactory
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    public LocalSessionFactoryBean sessionFactory(@Qualifier("dataSource") DruidDataSource dataSource) {

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan(this.packageScan);
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", this.dialect);
        properties.setProperty("hibernate.show_sql", this.showSql);
        properties.setProperty("hibernate.format_sql", this.formatSql);
        properties.setProperty("hibernate.use_sql_comments", this.useSqlComments);
        properties.setProperty("hibernate.hbm2ddl.auto", this.ddlAuto);
        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }

    //配置hibernate事务处理
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        DruidDataSource dataSource = new DruidDataSource();
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setDataSource(dataSource);
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
