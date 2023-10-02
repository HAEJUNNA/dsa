/**
 * 
 */
package com.dsa.application.config;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dsa.application.dao.DsaDao;
import com.dsa.application.service.impl.DasServiceImpl;

@Configuration
public class SpringConfig {
	
	//@Configuration 어노테이션을 스프링이 인식하고
	//해당 빈들을 등록한다.
//	@Bean
//	public DasServiceImpl dasService() {
//		return new DasServiceImpl(dsaDao);
//	}
//	
//	@Bean DsaDao dsaDao() {
//		return new DsaDao(SqlSession);
//	}
}
