/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dhl.mapper.QueryMapper;
import com.dhl.service.QueryService;

/**
 *@作者:風の住む街
 *@说明:配置类
 */
@Configuration
@ComponentScan(basePackages = {"com.dhl"})
public class QueryBeanConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:sqlite::resource:com/dhl/data/data.db");
		dataSource.setDriverClassName("org.sqlite.JDBC");
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:com/dhl/mapper/QueryMapper.xml"));
		return sqlSessionFactory.getObject();
	}
	
	@Bean
	public QueryMapper queryMapper() throws Exception {
		MapperFactoryBean mapperFactoryBean = new MapperFactoryBean();
		mapperFactoryBean.setMapperInterface(QueryMapper.class);
		mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory());
		return (QueryMapper) mapperFactoryBean.getObject();
	}
	
	@Bean
	public QueryService queryService() {
		QueryService queryService = new QueryService();
		return queryService;
	}
}
