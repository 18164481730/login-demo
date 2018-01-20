package com.tangzhihe.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;
import com.alibaba.fastjson.JSON;

@SuppressWarnings("rawtypes")
public final class Md5Util {
	public final static String MD5_CODE_STR="5d72ee6e-7128-4828-920f-ba941450cd4d";// 统一加密KEY
	/**
	 * MD5加密
	 * 
	 * @param content - 内容
	 * @param keyWord - 各系统key
	 * @return String 加密后字符串
	 * @throws
	 */
	public static String encrypt(String content) {
		return DigestUtils.md5Hex(content);
	}

	/**
	 * 校验秘钥 
	 * 
	 * @param sign - 秘钥
	 * @param content - 内容
	 * @param keyWord - 各系统key
	 * @return boolean 校验结果
	 * @throws
	 */
	public static boolean verifySign(String sign, String content) {
		if (!sign.isEmpty() && !content.isEmpty()) {
			String encryptStr = DigestUtils.md5Hex(content);
			if (sign.equalsIgnoreCase(encryptStr)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	 /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
	private static Map<String, String> paraFilter(Map sArray) {

        Map<String, String> result = new HashMap<String, String>();
        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
       
        result.put("signKey",MD5_CODE_STR);
        for (Object key : sArray.keySet()) {
        	Object obj =sArray.get(key);
            if (obj == null || key.toString().equalsIgnoreCase("sign")) {
                continue;
            }
            String value = JSON.toJSONString(sArray.get(key)).replace("\"", "");
            result.put(key.toString(), value);
        }
      
        return result;
    }

    /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
	public static String createLinkString(Map sArray) {
		Map<String, String> params = paraFilter(sArray);
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }
	
	public static void main(String[] args) {
		System.out.println(encrypt("123456"));
	}
}
