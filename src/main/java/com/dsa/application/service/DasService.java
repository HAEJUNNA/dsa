package com.dsa.application.service;

import java.util.Map;

import com.dsa.application.dto.UserDto;
import com.dsa.application.entity.User;

public interface DasService {
	
	/**
	 * selectUserIdCheck
	 * ================================
	 * @NAME:나해준    @DAY: 2023. 8. 27.
	 * ================================
	 * @param ud
	 * @return 회원 등록여부
	 * @throws Exception
	 * ================================
	 * @Method : 등록된 회원인지 체크한다.
	 * @변경이력 :
	 */
	public Map<String,Object> selectUserIdCheck(User ud) throws Exception;
	
	/**
	 * selectChekUserInfo
	 * ================================
	 * @NAME:나해준    @DAY: 2023. 9. 24.
	 * ================================
	 * @param ud
	 * @return
	 * ================================
	 * @Method : 회원 ID로 회원 정보를 조회한다.
	 * @변경이력 :
	 */
	public Map<String,Object>  selectChekUserInfo(UserDto ud) throws Exception;
	
	/**
	 * insertUser
	 * ================================
	 * @NAME:나해준    @DAY: 2023. 8. 27.
	 * ================================
	 * @param ud
	 * @return 회원가입 결과
	 * @throws Exception
	 * ================================
	 * @Method : 회원정보를 입력받아 회원정보를 등록한다.
	 * @변경이력 :
	 */
	public int insertUserInfo(User ud)throws Exception;
}
