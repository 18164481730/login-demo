package com.tangzhihe.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 * @author ouzhb
 */
public class StringUtil {

	/**
	 * 判断字符串是否为null、“ ”、“null”
	 * @param obj
	 * @return
	 */
	public static boolean isNull(String obj) {
		if (obj == null){
			return true;
		}else if (obj.toString().trim().equals("")){
			return true;
		}else if(obj.toString().trim().toLowerCase().equals("null")){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不为空
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(String obj) {
		return !isNull(obj);
	}
}
