package com.goodsoft.landscape.dao.daolmpl;

import com.goodsoft.landscape.dao.UserManageDao;
import com.goodsoft.landscape.entity.users.Grade;
import com.goodsoft.landscape.entity.users.Rights;
import com.goodsoft.landscape.entity.users.User;
import com.goodsoft.landscape.entity.users.UserInfo;
import com.goodsoft.landscape.factory.FactoryDao;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 用户管理访问数据库Java类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
@SuppressWarnings("ALL")
@Repository
public class UserManageDaolmpl extends FactoryDao implements UserManageDao {

    /**
     * 功能： 用户登录dao接口实现类
     *
     * @return 用户信息
     * @parameter user 用户信息
     */
    public UserInfo login(User user) {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class, "u");
        ProjectionList field = Projections.projectionList();
        field.add(Property.forName("u.uid").as("uid"));
        field.add(Property.forName("u.userName").as("userName"));
        field.add(Property.forName("u.tel").as("tel"));
        field.add(Property.forName("u.roleId").as("roleId"));
        field.add(Property.forName("u.head").as("head"));
        field.add(Property.forName("u.dates").as("dates"));
        dc.add(Restrictions.or(Restrictions.eq("userName", user.getUserName()),
                Restrictions.eq("tel", user.getUserName())));
        dc.add(Restrictions.eq("passWord", user.getPassWord()));
        dc.add(Restrictions.eq("isNo", 0));
        dc.setProjection(field);
        return (UserInfo) dc.getExecutableCriteria(super.getSession())
                .setResultTransformer(Transformers.aliasToBean(UserInfo.class))
                .uniqueResult();
    }

    /**
     * 功能：检查用户名是否重复dao接口实现类
     *
     * @return Boolean值
     * @parameter name 用户名
     */
    public boolean checkName(String name) {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class, "u");
        ProjectionList field = Projections.projectionList();
        field.add(Property.forName("u.uid").as("uid"));
        dc.add(Restrictions.eq("userName", name));
        dc.setProjection(field);
        List data = dc.getExecutableCriteria(super.getSession()).list();
        if (data.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 功能：检查手机号是否重复dao接口实现类
     *
     * @return Boolean值
     * @parameter tel 用户手机信息
     */
    public boolean checkTel(String tel) {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class, "u");
        ProjectionList field = Projections.projectionList();
        field.add(Property.forName("u.uid").as("uid"));
        dc.add(Restrictions.eq("tel", tel));
        dc.setProjection(field);
        List data = dc.getExecutableCriteria(super.getSession()).list();
        if (data.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 功能：检查系统权限数据是否存在（防止服务器重启再次初始化权限数据）dao方法
     *
     * @return Boolean
     * @parameter 无
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Rights> queryRights() {
        DetachedCriteria dc = DetachedCriteria.forClass(Rights.class);
        dc.add(Restrictions.eq("rid", 1));
        return dc.getExecutableCriteria(super.getSession()).list();
    }

    /**
     * 初始化用户具有系统权限dao接口
     *
     * @parameter var 用户权限等级
     * <p>
     * return 权限等级编号
     */
    @Override
    public Grade queryRightsById(int var) {
        DetachedCriteria dc = DetachedCriteria.forClass(Grade.class, "g");
        ProjectionList field = Projections.projectionList();
        field.add(Property.forName("g.roleId").as("roleId"));
        dc.add(Restrictions.eq("level", var));
        dc.setProjection(field);
        return (Grade) dc.getExecutableCriteria(super.getSession())
                .setResultTransformer(Transformers.aliasToBean(Grade.class))
                .uniqueResult();
    }

    /**
     * 功能：用户注册dao接口实现类
     *
     * @return 无
     * @parameter user 用户信息
     */
    public void register(final User user) throws Exception {
        synchronized (user) {
            super.getSession().save(user);
        }
        super.getSession().clear();
    }


    /**
     * 功能：初始化系统权限管理dao接口
     *
     * @return 无
     * @parameter rights 权限信息，grade 权限等级信息
     */
    @Override
    public void rightsInitialization(List<Rights> rights, List<Grade> grade) throws Exception {
        for (int i = 0, length = rights.size(); i < length; ++i) {
            super.getSession().save(rights.get(i));
            super.getSession().save(grade.get(i));
            super.getSession().clear();
        }
    }

}
