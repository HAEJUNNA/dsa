/**
 * 
 */
package com.dsa.application.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


/**
 * 
 */
@Configuration
public class MyBatisConfig {
	// applcation.yml 에서 정의한 마이바티스 메퍼 주소를 가져온다.
	@Value("${mybatis.mapper-locations}")
	private String mapperLocations;
	// applcation.yml 에서 정의한 마이바티스 config 주소를 가져온다.
	@Value("${mybatis.config-location}")
	private String mybatisConfigFile;
	
	@Bean(name ="mybatisDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public DataSource dataSource() {
		// build를 통해 hikari 하위에있는 모든 정보를 주입시켜준다.
		return DataSourceBuilder.create().build();
	}
	
	// @Primary와 @Qualifier의 우선 순위
	// 스프링은 기본적으로 자동보다 수동으로 지정한 것이 높은 우선 순위를 갖는다. 
	// 따라서 자동적으로 빈을 선택해주는 @Primary보다 명시적으로 지정하는 @Qualifier 어노테이션이 우선 순위를 가진다.
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(@Qualifier("mybatisDataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		// 데이터 소스 정보
		factoryBean.setDataSource(dataSource);
		
		// mybatis 매퍼 설정 파일 세팅 (config파일을 따로 설정할경우 방법)
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
		
		// mybatis config 설정 파일 세팅 (config파일을 따로 설정할경우 방법)
		factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(mybatisConfigFile));
		
		 // mybatis config 설정 파일 세팅 (경로를 직접 입력하는경우)
//		factoryBean.setTypeAliasesPackage("com.dsa.application.DsaDao");
        
        	
		return factoryBean.getObject();
	}
	
// config파일 없이 application.yml에 있는 prefix 매핑시켜 application.ymㅉ에서 마이바티스에 config에 설정한 모든설정을 주입시키는 방식	
//	@Bean
//	@ConfigurationProperties(prefix = "mybatis.configuration")
//	public org.apache.ibatis.session.Configuration mybatisConfg() {
//	return new org.apache.ibatis.session.Configuration();
//	}
	
	// sqlTemplate 설정
	@Bean
    public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
