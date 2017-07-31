package com.goodsoft.landscape.config.context;

import com.goodsoft.landscape.service.UserManageServie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * function 启动服务初始化权限管理数据
 * <p>
 * Created by 严彬荣 on 2017/7/25.
 */
@Component
public class RightInitialization implements CommandLineRunner {
    @Resource
    private UserManageServie servie;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>初始化系统数据...<<<<<<<<<<<<<");
        boolean tip = this.servie.queryRights();
        if (tip == false) {
            System.out.println(">>>>>>>>>>>>>>>初始化系统数据成功<<<<<<<<<<<<<");
        } else {
            boolean tip2 = this.servie.rightsInitialization();
            if (tip2 == false) {
                System.out.println(">>>>>>>>>>>>>>>初始化系统数据成功<<<<<<<<<<<<<");
            } else {
                System.out.println(">>>>>>>>>>>>>>>初始化系统数据成功<<<<<<<<<<<<<");
            }
        }

    }
}
