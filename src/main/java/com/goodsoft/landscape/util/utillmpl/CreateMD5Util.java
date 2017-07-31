package com.goodsoft.landscape.util.utillmpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * function md5加密工具类
 * 
 * date 2017.03.20
 * 
 * @author 严彬荣
 */
public class CreateMD5Util {

	/* 创建本类的单例模式（具体说明参见本包下UUIDUtil类） */

	private volatile static CreateMD5Util instance;

	private CreateMD5Util() {
	}

	public static CreateMD5Util getInstance() {
		if (instance == null) {
			synchronized (CreateMD5Util.class) {
				if (instance == null)
					instance = new CreateMD5Util();
			}
		}
		return instance;
	}

	public String getMd5(String str) throws Exception {
		try {
			// 实例化md5加密方式
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 更新摘要
			md.update(str.getBytes());
			// 拿到摘要
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			// 执行加密
			for (int j = 0, length = b.length; j < length; j++) {
				i = b[j];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密方式
			// return buf.toString();
			// 16位加密方式
			return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
