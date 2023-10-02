package com.dsa.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DsaApplication {
	// 아무패키지나 만들어서 컴포넌트로 등록해서 사용할수있는게 아니다.
	// 기본적으로 스프링 프로젝트를 만들게되면 이 해당 파일을 기점으로 스프링이 실행된다.
	// 그렇기 때문에 내가 아무리 com.dsa.application 가 관련없는 곳에 패키지를 만들다 한들 적용되지 않는다.
	// 그렇기때문에 이 프로젝트가 실행되면서 자동으로 컴포넌트 스캔할수 있는 기본  path 는 com.dsa.application 이 된다.
	// com.dsa.application 이 하위에있는 모든 패키지를 다 찾아서 @Component 어노테이션 명시한 애들만
	// 컴포넌트 스캔이 가능한것이다.
	// 다른 방법이 존재는 한다. 여기서 다르게 설정을하게되면 com.dsa.application 하위 아니더라도 모든곳에서 스캔이 가능하도록
	// 설정이 가능하지만 그런 설정을해주지 않는다면 기본적인 적용 루트는 com.dsa.application 이다.
	// @SpringBootApplication 안에 @ComponentScan 요게 있어서 가능
	public static void main(String[] args) {
		SpringApplication.run(DsaApplication.class, args);
	}

}
