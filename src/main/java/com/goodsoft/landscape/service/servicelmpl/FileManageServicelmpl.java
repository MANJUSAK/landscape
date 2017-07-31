package com.goodsoft.landscape.service.servicelmpl;

import com.goodsoft.landscape.dao.FileManageDao;
import com.goodsoft.landscape.service.FileManageService;
import com.goodsoft.landscape.util.resulteutil.ResultOne;
import com.goodsoft.landscape.util.resulteutil.Status;
import com.goodsoft.landscape.util.resulteutil.StatusEnum;
import com.goodsoft.landscape.util.utillmpl.DomainNameUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * function 文件管理业务逻辑处理实现类
 * <p>
 * Created by 严彬荣 on 2017/7/28.
 */
@SuppressWarnings("ALL")
@Service
public class FileManageServicelmpl implements FileManageService {

    @Resource
    private FileManageDao dao;
    // 实例化log日志管理器
    private Logger logger = Logger.getLogger(DeviceManageServicelmpl.class);
    //实例化服务器域名地址工具类
    private DomainNameUtil http = DomainNameUtil.getInstance();
    //实例化返回结果集实体类
    private ResultOne result = null;

    /**
     * 查询文件数据
     * <p>
     *
     * @return 查询数据
     * @parameter var 所需用户信息，request http请求（用于获取服务器域名地址方便下载文件），c 封装类
     */
    @Override
    public <T> T queryFileService(String arg, HttpServletRequest request, Class c) {
        List data = null;
        try {
            data = this.dao.queryFileDao(arg, c);
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        if (data.size() > 0) {
            this.result = new ResultOne(0, data);
            this.result.setPath(this.http.getDomainName(request).toString());
            return (T) this.result;
        } else {
            return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
        }

    }

    /**
     * 文件数据保存
     * <p>
     *
     * @return boolean
     * @parameter var 需要保存的文件数据
     */
    @Override
    public boolean saveFileService(Object var) {
        try {
            this.dao.saveFileDao(var);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return false;
        }

    }
}
