/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *@作者:風の住む街
 *@说明:返回类
 */
public class ReturnInfo {
	public static String SUCCESS_FLAG = "1";
	public static String FALID_FLAG = "0";
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-02 18:51:56
	 * @备注:获取操作结果
	 *
	 */
	public static Map<String, Object> getResultInfo(String flag,String message,Object dataList){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		map.put("message", message);
		map.put("data", dataList);
		return map;
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-02 18:54:43
	 * @备注:获取成功信息
	 *
	 */
	public static Map<String, Object> getSuccessInfo(String flag,String message){
		Object dataList = null;
		return getResultInfo(flag,message,dataList);
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-02 18:54:43
	 * @备注:获取成功信息
	 *
	 */
	public static Map<String, Object> getSuccessInfo(String flag){
		Object dataList = null;
		return getResultInfo(flag,"获取数据成功!",dataList);
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-02 18:54:23
	 * @备注:获取成功信息
	 *
	 */
	public static Map<String, Object> getSuccessInfo(){
		Object dataList = null;
		return getResultInfo(SUCCESS_FLAG,"获取数据成功!",dataList);
	}
	
	
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-02 18:54:43
	 * @备注:获取成功信息
	 *
	 */
	public static Map<String, Object> getFaildInfo(String flag,String message){
		Object dataList = null;
		return getResultInfo(flag,message,dataList);
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-02 18:54:43
	 * @备注:获取成功信息
	 *
	 */
	public static Map<String, Object> getFaildInfo(String flag){
		Object dataList = null;
		return getResultInfo(flag,"获取数据失败!",dataList);
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-02 18:54:23
	 * @备注:获取成功信息
	 *
	 */
	public static Map<String, Object> getFaildInfo(){
		Object dataList = null;
		return getResultInfo(SUCCESS_FLAG,"获取数据失败!",dataList);
	}
	
}
