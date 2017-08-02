package com.goodsoft.landscape.service.servicelmpl;

import com.goodsoft.landscape.dao.FileManageDao;
import com.goodsoft.landscape.entity.file.ExcelFile;
import com.goodsoft.landscape.service.FileManageService;
import com.goodsoft.landscape.util.resulteutil.Result;
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

    /**
     * 查询excel文件数据
     * <p>
     *
     * @return 查询数据
     * @parameter var 所需用户信息，request http请求（用于获取服务器域名地址方便下载文件），c 封装类
     */
    @Override
    public <T> T queryFileService(String arg, HttpServletRequest request) {
        List<ExcelFile> data = null;
        try {
            data = this.dao.queryFileDao(arg, ExcelFile.class);
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        if (data.size() > 0) {
            String var = this.http.getDomainName(request).toString();
            for (int i = 0, length = data.size(); i < length; ++i) {
                data.get(i).setPath(var + data.get(i).getPath());
            }
            return (T) new Result(0, data);
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
