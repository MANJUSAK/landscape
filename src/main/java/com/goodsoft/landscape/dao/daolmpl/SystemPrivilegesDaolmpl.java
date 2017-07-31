package com.goodsoft.landscape.dao.daolmpl;

import com.goodsoft.landscape.dao.SystemPrivilegesDao;
import com.goodsoft.landscape.entity.users.Grade;
import com.goodsoft.landscape.factory.FactoryDao;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 * function 系统权限管理数据库操作类
 * <p>
 * Created by 严彬荣 on 2017/7/25.
 */
@Repository
public class SystemPrivilegesDaolmpl extends FactoryDao implements SystemPrivilegesDao {

    /**
     * function 系统权限判断dao方法
     *
     * @parameter var 权限编号
     * <p>
     * return 权限等级
     */
    @Override
    public Grade judgeRights(String var) {
        DetachedCriteria dc = DetachedCriteria.forClass(Grade.class, "g");
        ProjectionList field = Projections.projectionList();
        field.add(Property.forName("g.level").as("level"));
        dc.add(Restrictions.eq("roleId", var));
        dc.setProjection(field);
        return (Grade) dc.getExecutableCriteria(super.getSession())
                .setResultTransformer(Transformers.aliasToBean(Grade.class))
                .uniqueResult();
    }
}
