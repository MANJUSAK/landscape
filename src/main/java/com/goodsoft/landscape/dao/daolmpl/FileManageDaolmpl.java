package com.goodsoft.landscape.dao.daolmpl;

import com.goodsoft.landscape.dao.FileManageDao;
import com.goodsoft.landscape.factory.FactoryDao;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

/**
 * function 文件管理访问数据dao实现类
 * Created by 严彬荣 on 2017/7/28.
 */
@SuppressWarnings("ALL")
@Service
public class FileManageDaolmpl extends FactoryDao implements FileManageDao {
    /**
     * 文件查询dao方法
     *
     * @return 查询结果
     * @parameter var 查询条件，c 需要封装实体类
     */
    @Override
    public <T> T queryFileDao(String arg, Class c) {
        DetachedCriteria dc = DetachedCriteria.forClass(c, "c");
        ProjectionList field = Projections.projectionList();
        field.add(Property.forName("c.path").as("path"));
        field.add(Property.forName("c.types").as("types"));
        dc.add(Restrictions.and(Restrictions.eq("uid", arg),
                Restrictions.eq("isNo", 0)));
        dc.addOrder(Order.desc("fid"));
        dc.setProjection(field);
        return (T) dc.getExecutableCriteria(super.getSession())
                .setResultTransformer(Transformers.aliasToBean(c))
                .list();
    }

    /**
     * 文件保存dao方法
     *
     * @return 无
     * @parameter var 需保存数据
     */
    @Override
    public void saveFileDao(Object var) throws Exception {
        super.getSession().save(var);
        super.getSession().clear();

    }
}
