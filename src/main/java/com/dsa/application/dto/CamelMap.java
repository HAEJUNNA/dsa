/**
 * 
 */
package com.dsa.application.dto;

import java.util.HashMap;

import org.checkerframework.common.util.report.qual.ReportOverride;
import org.springframework.jdbc.support.JdbcUtils;

/**
 * mybatis에 mybatis-config.xml 에 mapUnderscoreToCamelCase 속성은 
 * 자바빈즈(DTO/VO)만 적용되고 컬렉션속성(map)은 적용되지 않는다.
 * Map,HasMap을 resultType를 선언할 경우에 key 가 대문자로 들어간다 (oracle 등에 한하여)
 * 현재 Mybatis 측에서 공식적으로 지원하지 않는다고 알고 있어서 나의 경우 return 받는 객체 에서 처리했다.
 * 그렇기 떄문에 따로 dto에서 맵을 카멜케이스로 치환해주는 함수를 만들던가 해야하는데 전자정부프레임워크 방식에서는
 * Map을 상속받는 클래스를 생성하고 put 함수를 가로채 key를 lowerCase로 치환해주는 새로운 Map 객체를 만들어서 사용하는 것이다.
 */
public class CamelMap extends HashMap{
	// 자바 직렬화
	// 자바 스펙에 따르면 serialVersionUID 가 선언되어있지 않을 경우 default로 값을 만들어준다고 한다.
	// 하지만 이 값은 컴파일러의 구현에 따라 달라질 수 있기 때문에 역직렬화 시 예기치 못하게 실패할 수도 있다고 한다.
//	private static final long serialVersionUID = -7700790403928325865L;

	@SuppressWarnings("unchecked")
	@ReportOverride
	public Object put(Object key, Object value) {
		return super.put(JdbcUtils.convertUnderscoreNameToPropertyName((String)key), value);
		
	}
}
