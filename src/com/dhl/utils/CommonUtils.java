/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

/**
 *@作者:風の住む街
 *@说明:公共类
 */
public class CommonUtils {
	private static Log log = LogFactory.getLog(CommonUtils.class);
	private static final String WIN_ID = "Windows";
	private static final String MAC_ID = "Mac";
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-02 19:22:33
	 * @备注:打开win平台浏览器
	 *
	 */
	public static Map<String, Object> openWinBrowserWithUrl(String sourceUrl) {
		if (StringUtils.isEmpty(sourceUrl)) {
			return ReturnInfo.getFaildInfo();
		}else {
			try {
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+sourceUrl);
			} catch (IOException e) {
				e.printStackTrace();
				if(log.isErrorEnabled()) {
					log.error("打开浏览器出现错误:",e);
				}
			}
		}
		return ReturnInfo.getSuccessInfo();
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-02 19:22:53
	 * @备注:打开mac平台浏览器
	 *
	 */
	public static void openMacBrowserWithUrl(String sourceUrl) {
        try{
            Class MRJFileUtils = Class.forName("com.apple.mrj.MRJFileUtils");
            Method openMethod = MRJFileUtils.getDeclaredMethod("openURL", new Class[] {String.class});
            openMethod.invoke(MRJFileUtils,new Object[]{formatString(sourceUrl)});
        } catch(Exception e) {
        	e.printStackTrace();
			if(log.isErrorEnabled()) {
				log.error("打开浏览器出现错误:",e);
			}
        }
    }
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-02 19:23:09
	 * @备注:格式化URL ,Mac平台用
	 *
	 */
	 public static String formatString(String str) {
	        String retString="";
	        String protocol = "";
	        String host = "";
	        String path = "";
	        
	        try {
	            java.net.URL url = new java.net.URL(str);
	            protocol = url.getProtocol();
	            host = url.getHost();
	            path = url.getPath();
	        } catch (MalformedURLException ex) {
	            path = str;
	        }
	        
	        for(int i = 0; i < path.length(); i++) {
	            if(path.charAt(i) == ' ') {
	                retString += "%20";
	            } else if(path.charAt(i) == '.') {
	                retString += "%2E";
	            } else {
	                retString += path.substring(i, i + 1);
	            }
	        }
	        
	        if (!protocol.equals("")) {
	            retString = protocol + "://" + host + retString;
	        } else {
	            retString = host + retString;
	        }
	        
	        return retString ;
	    }
	 
	 /**
	  * 
	  * @作者:風の住む街
	  * @时间:2020-02-02 19:23:24
	  * @备注:判断是win
	  *
	  */
	 public static boolean isWindowsPlatform() {
	        String os = System.getProperty("os.name");
	        
	        if ( os != null && os.startsWith(WIN_ID))
	            return true;
	        else
	            return false;
	    }
	 
	 /**
	  * 
	  * @作者:風の住む街
	  * @时间:2020-02-02 19:23:33
	  * @备注:判断是mac
	  *
	  */
	 public static boolean isMacPlatform() {
	        String os = System.getProperty("os.name");
	        if ( os != null && os.startsWith(MAC_ID))
	            return true;
	        else
	            return false;
	    }
	 
}
