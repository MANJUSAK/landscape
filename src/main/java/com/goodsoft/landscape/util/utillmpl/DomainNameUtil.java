package com.goodsoft.landscape.util.utillmpl;

import javax.servlet.http.HttpServletRequest;

/**
 * function 获取服务器域名工具类
 * 
 * date 2017.03.09
 * 
 * @author 严彬荣
 */
public class DomainNameUtil {

	/* 创建本类的单例模式（具体说明参见本包下UUIDUtil类） */
	private volatile static DomainNameUtil instance;

	private DomainNameUtil() {
	}

	public static DomainNameUtil getInstance() {
		if (instance == null) {
			synchronized (DomainNameUtil.class) {
				if (instance == null)
					instance = new DomainNameUtil();
			}
		}
		return instance;
	}

	// 获得服务器域名并返回
	public StringBuilder getDomainName(HttpServletRequest request) {
		StringBuilder domainName = null;
		// 判断服务器端口号是否为80
		if (request.getServerPort() == 80) {
			domainName = new StringBuilder(request.getScheme() + "://"
					+ request.getServerName());
		} else {
			domainName = new StringBuilder(request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort());
		}
		return domainName;
	}
}
