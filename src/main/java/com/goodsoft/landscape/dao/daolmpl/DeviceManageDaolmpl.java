package com.goodsoft.landscape.dao.daolmpl;

import com.goodsoft.landscape.dao.DeviceManageDao;
import com.goodsoft.landscape.factory.FactoryDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 设备管理访问数据库Java类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
@Repository
public class DeviceManageDaolmpl extends FactoryDao implements DeviceManageDao {
    /**
     * 功能：查询设备管理数据dao方法
     *
     * @return 设备管理数据list
     * @parameter 无
     */
    @SuppressWarnings("unchecked")
    @Override
    public List queryDao(int page, int num, String id, Class t) {
        // TODO Auto-generated method stub
        DetachedCriteria dc = DetachedCriteria.forClass(t);
        dc.add(Restrictions.eq("isNo", 0));
        dc.addOrder(Order.desc(id));
        Criteria ct = dc.getExecutableCriteria(super.getSession());
        int lastPage = page * num;
        ct.setFirstResult(lastPage);
        ct.setMaxResults(num);
        return ct.list();
    }

    @Override
    public List queryDao(String id, Class c) {
        DetachedCriteria dc = DetachedCriteria.forClass(c);
        dc.add(Restrictions.eq("isNo", 0));
        dc.addOrder(Order.desc(id));
        Criteria ct = dc.getExecutableCriteria(super.getSession());
        ct.setMaxResults(500);
        return ct.list();
    }

    /**
     * 功能：设备管理数据录入dao方法
     *
     * @return 无
     * @parameter msg 数据信息
     */
    @Override
    public void saveDao(final Object msg) throws Exception {
        super.getSession().save(msg);
        super.getSession().clear();
    }

}
