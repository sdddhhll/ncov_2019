/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.tabledata;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dhl.config.QueryBeanConfig;
import com.dhl.service.QueryService;

/**
 *@作者:風の住む街
 *@说明:数据工具类
 */
public class DataUtil {
	public static  AnnotationConfigApplicationContext  annotationConfigApplicationContext = new AnnotationConfigApplicationContext(QueryBeanConfig.class);
	public static  QueryService queryService = annotationConfigApplicationContext.getBean("queryService",QueryService.class);
}
