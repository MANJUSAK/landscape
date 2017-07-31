package com.goodsoft.landscape.service.servicelmpl;

import com.goodsoft.landscape.dao.UserManageDao;
import com.goodsoft.landscape.entity.users.Grade;
import com.goodsoft.landscape.entity.users.Rights;
import com.goodsoft.landscape.entity.users.User;
import com.goodsoft.landscape.service.UserManageServie;
import com.goodsoft.landscape.util.utillmpl.CreateMD5Util;
import com.goodsoft.landscape.util.utillmpl.DomainNameUtil;
import com.goodsoft.landscape.util.utillmpl.UUIDUtil;
import com.goodsoft.landscape.util.utillmpl.UserFileUploadUtil;
import com.goodsoft.landscape.util.resulteutil.ResultOne;
import com.goodsoft.landscape.util.resulteutil.ResultTwo;
import com.goodsoft.landscape.util.resulteutil.Status;
import com.goodsoft.landscape.util.resulteutil.StatusEnum;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * function 用户管理业务逻辑处理Java类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
@SuppressWarnings("ALL")
@Service
public class UserManageServicelmpl implements UserManageServie {

    @Resource
    private UserManageDao dao;
    //实例化og日志管理
    private Logger logger = Logger.getLogger(UserManageServicelmpl.class);
    // 实例化用户文件上传工具类
    private UserFileUploadUtil userFile = UserFileUploadUtil.getInstance();
    // 实例化md5加密类
    private CreateMD5Util md5 = CreateMD5Util.getInstance();
    // 实例化结果集实体类
    private ResultOne resultOne = null;
    private ResultTwo resultTwo = null;
    // 实例化服务器域名地址工具类
    private DomainNameUtil domainName = DomainNameUtil.getInstance();
    //实例化uuid工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();

    /*
     * 功能：用户登录接口实现类
     *
     * @parameter user 用户信息、request http请求
     *
     * @return object对象
     */
    public <T> T login(User user, HttpServletRequest request) {
        // 进行md5解密
        StringBuilder pw = null;
        try {
            pw = new StringBuilder(user.getPassWord().substring(3, 6));
            pw.append(this.md5.getMd5(user.getPassWord()));
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            System.out.println(e1.toString());
            this.logger.error(e1);
            return (T) new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
        user.setPassWord(pw.toString().toUpperCase());
        User data = null;
        try {
            data = this.dao.login(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            this.logger.error(e);
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        if (data != null) {
            if (!"null".equals(data.getHead())) {
                this.resultOne = new ResultOne(0, data);
                this.resultOne.setPath(this.domainName.getDomainName(request)
                        .toString());
                return (T) this.resultOne;
            } else {
                this.resultTwo = new ResultTwo(0, data);
                return (T) this.resultTwo;
            }

        } else {
            return (T) new Status(StatusEnum.LOGIN_DEFEAT.getCODE(), StatusEnum.LOGIN_DEFEAT.getEXPLAIN());
        }

    }

    /*
     * 功能：用户注册接口实现类
     *
     * @parameter user 用户信息、files 用户头像、request http请求
     *
     * @return 注册提示信息
     */
    @Transactional
    public Status register(MultipartFile files, User user, HttpServletRequest request) {
        // 判断文件大小是否大于50kb
        if (files.getSize() > 50000) {
            return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
        }
        // 判断用户名是否存在
        boolean tip1 = this.dao.checkName(user.getUserName());
        if (tip1 == true) {
            // 判断手机号是否存在
            boolean tip2 = this.dao.checkTel(user.getTel());
            if (tip2 == false) {
                return new Status(StatusEnum.TEL_EXIST.getCODE(), StatusEnum.TEL_EXIST.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NAME_EXIST.getCODE(), StatusEnum.NAME_EXIST.getEXPLAIN());
        }
        // 进行md5加密
        StringBuilder pw = null;
        try {
            pw = new StringBuilder(user.getPassWord().substring(3, 6));
            pw.append(this.md5.getMd5(user.getPassWord()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            this.logger.error(e);
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
        user.setPassWord(pw.toString().toUpperCase());
        String msg = null;
        try {
            msg = this.userFile.userHeadUpload(files, request);
        } catch (Exception e1) {
            System.out.println(e1.toString());
            this.logger.error(e1);
            return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
        }
        if (msg == null) {
            return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
        }
        user.setHead(msg);
        user.setUid(this.uuid.getUUID().toString());
        try {
            Grade grade = this.dao.queryRightsById(0);
            user.setRoleId(grade.getRoleId());
            this.dao.register(user);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            this.logger.error(e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }

    /*
       * 功能：服务器启动初始化系统权限管理
       *
       * @parameter 无
       *
       * @return Boolean
       */
    @Override
    @Transactional
    public boolean rightsInitialization() {
        List<Rights> rightsList = new ArrayList<Rights>();
        List<Grade> gradeList = new ArrayList<Grade>();
        Rights rights = new Rights();
        Grade grade = new Grade();
        rights.setRole("高级管理员");
        rights.setRoleId(this.uuid.getUUID().toString());
        rightsList.add(rights);
        grade.setRoleId(rights.getRoleId());
        grade.setLevel(5);
        grade.setLevelId(this.uuid.getUUID().toString());
        gradeList.add(grade);
        for (int i = 4; i > 1; --i) {
            Rights rights1 = new Rights();
            Grade grade1 = new Grade();
            rights1.setRole("管理员" + (i - 1));
            rights1.setRoleId(this.uuid.getUUID().toString());
            rightsList.add(rights1);
            grade1.setRoleId(rights1.getRoleId());
            grade1.setLevel(i);
            grade1.setLevelId(this.uuid.getUUID().toString());
            gradeList.add(grade1);
        }
        Rights rights2 = new Rights();
        Grade grade2 = new Grade();
        rights2.setRole("系统用户");
        rights2.setRoleId(this.uuid.getUUID().toString());
        rightsList.add(rights2);
        grade2.setRoleId(rights2.getRoleId());
        grade2.setLevel(0);
        grade2.setLevelId(this.uuid.getUUID().toString());
        gradeList.add(grade2);
        try {
            this.dao.rightsInitialization(rightsList, gradeList);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return false;
        }
    }

    /*
       * 功能：检查系统权限数据是否存在（防止服务器重启再次初始化权限数据）
       *
       * @parameter 无
       *
       * @return Boolean
    */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public boolean queryRights() {
        List<Rights> data = null;
        try {
            data = this.dao.queryRights();
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return false;
        }
        if (data.size() > 0) {
            return false;
        } else {
            return true;
        }

    }
}
