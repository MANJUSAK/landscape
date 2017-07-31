package com.goodsoft.landscape.formfilter.formfilterlmpl;

import com.goodsoft.landscape.entity.users.User;
import com.goodsoft.landscape.formfilter.UserFormFilter;
import org.springframework.stereotype.Service;

/**
 * function 用户管理表单过滤类
 * <p>
 * date 2017.06.20
 *
 * @author 严彬荣
 */
@Service
public class UserFormFilterlmpl implements UserFormFilter {

    // 手机号正则
    private final String TEL = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[^4,5-9]))\\d{8}$";
    // 纯数字正则
    private final String NUM = "^[0-9]*$";

    /**
     * 用户登录表单验证
     * <p>
     * parameter： user 用户信息
     */
    public boolean loginForm(User user) {
        /* 验证传参是否为null */
        if (user.getUserName() == null || user.getPassWord() == null) {
            return false;
        }
        /* 验证参数值是否符合系统要求 */
        if (user.getUserName().length() < 1) {
            return false;
        } else if (user.getPassWord().length() < 6) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 用户注册表单验证
     * <p>
     * parameter： user 用户信息
     */
    public boolean registerForm(User user) {
        /* 验证传参是否为null */
        if (user.getUserName() == null || user.getTel() == null
                || user.getPassWord() == null) {
            return false;
        }
        /* 验证参数值是否符合系统要求 */
        if (user.getUserName().length() < 1
                || user.getUserName().matches(this.NUM)) {
            return false;
        } else if (!user.getTel().matches(this.TEL)) {
            return false;
        } else if (user.getPassWord().length() < 6
                || user.getPassWord().length() > 16) {
            return false;
        } else {
            return true;
        }
    }
}
