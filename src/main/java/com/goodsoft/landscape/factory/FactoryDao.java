package com.goodsoft.landscape.factory;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * function hibernate session工厂公共类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */

@Repository
public class FactoryDao {


    @Resource
    private SessionFactory sessionFactory;

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

}
