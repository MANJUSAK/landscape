package com.goodsoft.landscape.service.servicelmpl;

import com.goodsoft.landscape.dao.DeviceManageDao;
import com.goodsoft.landscape.entity.file.ExcelFile;
import com.goodsoft.landscape.service.FileDownload;
import com.goodsoft.landscape.service.FileManageService;
import com.goodsoft.landscape.service.SystemPrivilegesService;
import com.goodsoft.landscape.util.ExcelUtil;
import com.goodsoft.landscape.util.resulteutil.Parameter;
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
 * function 文件下载业务逻辑处理类
 * Created by 严彬荣 on 2017/7/27.
 */
@SuppressWarnings("ALL")
@Service
public class FileDownloadlmpl implements FileDownload {

    @Resource
    private ExcelUtil excelUtil;
    @Resource
    private SystemPrivilegesService Privilege;
    @Resource
    private FileManageService fileService;
    @Resource
    private DeviceManageDao deviceDao;
    //实例化服务器域名地址工具类
    private DomainNameUtil http = DomainNameUtil.getInstance();
    //实例化返回结果集实体类
    private ResultOne result = null;

    //实例化日志管理工具类
    private Logger logger = Logger.getLogger(FileDownloadlmpl.class);

    /**
     * excel文件下载业务逻辑处理类
     *
     * @parameter request http请求（用于获取服务器域名地址，方便下载文件），var 下载文件所需参数
     */
    @Override
    public <T> T exceldownload(HttpServletRequest request, Parameter var, Class c) {
        //权限获取（判断该用户是否具有查看数据权限）
        int var1 = this.Privilege.judgeRights(var.getRoleId());
        if (var1 == 500) {
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        } else if (var1 == -1) {
            return (T) new Status(StatusEnum.UNKONW_ERROR.getCODE(), StatusEnum.UNKONW_ERROR.getEXPLAIN());
        } else if (var1 < 3) {
            return (T) new Status(StatusEnum.NO_RIGHTS.getCODE(), StatusEnum.NO_RIGHTS.getEXPLAIN());
        }
        String var2 = null;
        ExcelFile file = new ExcelFile();
        List data = null;
        try {
            data = this.deviceDao.queryDao(var.getId(), c);
            if (data.size() < 0) {
                return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            }
            var2 = this.excelUtil.writeExcel(request, data, var.getExcel());
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        file.setPath(var2);
        file.setUid(var.getUid());
        file.setTypes(var.getTypes());
        boolean var3 = this.fileService.saveFileService(file);
        if (var3 == false) {
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        this.result = new ResultOne(0, var2);
        this.result.setPath(this.http.getDomainName(request).toString());
        return (T) this.result;
    }
}
