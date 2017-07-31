package com.goodsoft.landscape.service.servicelmpl;

import com.goodsoft.landscape.dao.DeviceManageDao;
import com.goodsoft.landscape.service.DeviceManageService;
import com.goodsoft.landscape.service.SystemPrivilegesService;
import com.goodsoft.landscape.util.resulteutil.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * function 设备管理业务逻辑Java类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
@SuppressWarnings("ALL")
@Service
public class DeviceManageServicelmpl implements DeviceManageService {
    @Resource
    private DeviceManageDao dao;
    @Resource
    private SystemPrivilegesService service;
    // 实例化log日志管理器
    private Logger logger = Logger.getLogger(DeviceManageServicelmpl.class);


    /**
     * 功能：查询设备管理数据业务方法
     *
     * @return object对象
     * @parameter id 表主键，var 分页数据，var1 用户所需编号，c 封装类
     */
    @Override
    public <T> T queryService(PageUtil var, Parameter var1, Class c) {
        // TODO Auto-generated method stub
        //权限获取（判断该用户是否具有查看数据权限）
        int var2 = this.service.judgeRights(var1.getRoleId());
        if (var2 == 500) {
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        } else if (var2 == -1) {
            return (T) new Status(StatusEnum.UNKONW_ERROR.getCODE(), StatusEnum.UNKONW_ERROR.getEXPLAIN());
        } else if (var2 < 3) {
            return (T) new Status(StatusEnum.NO_RIGHTS.getCODE(), StatusEnum.NO_RIGHTS.getEXPLAIN());
        }
        //初始化查询总条数 不足20默认为20
        int var3 = var.getNum();
        if (var3 < 20 || var3 > 50) {
            var.setNum(20);
        }
        List data = null;
        try {
            data = this.dao.queryDao(var.getPage(), var.getNum(), var1.getId(), c);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            this.logger.error(e);
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        if (data.size() > 0) {
            return (T) new ResultTwo(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 功能：设备管理数据录入业务方法
     *
     * @return 录入状态提示status
     * @parameter msg 机械设备管理数据信息
     */
    @Override
    public Status saveService(Object msg) {
        // TODO Auto-generated method stub
        try {
            this.dao.saveDao(msg);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.logger.error(e);
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }
}
