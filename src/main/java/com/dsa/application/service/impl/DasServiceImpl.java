package com.dsa.application.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsa.application.dao.DsaDao;
import com.dsa.application.dto.Message;
import com.dsa.application.dto.UserDto;
import com.dsa.application.service.DasService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class DasServiceImpl implements DasService{
	

	private final DsaDao dsaDao;
	
	/**
	 * selectUserIdCheck
	 * ================================
	 * @NAME:나해준    @DAY: 2023. 8. 27.
	 * ================================
	 * @param ud[userId(사용자id), userPass(사용자pass)]
	 * @return 아이디,비밀번호 확인여부
	 * @throws Exception
	 * ================================
	 * @Method : 사용자 id ,비밀번호를 체크
	 * @변경이력 :
	 */
	@Override 
	public Map<String,Object> selectUserIdCheck(UserDto ud) throws Exception {
		Map <String, Object> temp = dsaDao.selectUserIdCheck(ud);
		Map<String, Object> result = new HashMap<>();
		String msg ="";
		String userFlag ="";
		log.debug(temp);
		if ("Y".equals(String.valueOf(temp.get("uid_result")))
				&& "Y".equals(String.valueOf(temp.get("upass_result")))) {
			msg = "회원확인이 완료되었습니다";
			userFlag = "Y";
		} else if("Y".equals(String.valueOf(temp.get("uid_result")))
				&& "N".equals(String.valueOf(temp.get("upass_result")))) {
			msg = "비밀번호가 일치하지 않습니다.";
			userFlag = "N";
		} else {
			msg = "회원정보가 존재하지않습니다.";
			userFlag = "N";
		}
		result.put("msg", msg);
		result.put("userFlag", userFlag);
		return result;
	}
	
	/**
	 * insertUserInfo
	 * ================================
	 * @NAME:나해준   @DAY: 2023. 9. 19.
	 * ================================
	 * @param ud
	 * @return
	 * @throws Exception
	 * ================================
	 * @Method : 회원의 정보를 저장한다.
	 * @변경이력 :
	 */
	public int insertUserInfo(UserDto ud) throws Exception{
		
		Map<String,Object> aa = dsaDao.selectUserIdCheck(ud);
		log.debug(aa);
		return 1;
	}
}
