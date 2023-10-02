package com.dsa.application.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsa.application.dao.DsaDao;
import com.dsa.application.dto.Message;
import com.dsa.application.dto.UserDto;
import com.dsa.application.service.DasService;
import com.dsa.application.type.UserRight;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
// 해당 서비스 어노테이션을 명시해줘야지만 스프링컨테이너에 등록이되서 컨트롤러에서 의존성주입이 가능하다.
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
		Map<String, Object> result = new HashMap<String, Object>();
		
		String msg ="";
		String userFlag ="";
		log.debug(temp);
		if ("Y".equals(String.valueOf(temp.get("uidResult")))
				&& "Y".equals(String.valueOf(temp.get("upassResult")))) {
			msg = "회원확인이 완료되었습니다";
			userFlag = "Y";
			Map<String,Object> userRigth = selectChekUserInfo(ud);
			result.put("userRigth", userRigth);
		} else if("Y".equals(String.valueOf(temp.get("uidResult")))
				&& "N".equals(String.valueOf(temp.get("upassResult")))) {
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
	public Map<String,Object>  selectChekUserInfo(UserDto ud){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> tempUd = dsaDao.selectChekUserInfo(ud);
		if (tempUd !=null) {
			if (String.valueOf(UserRight.LEVEL_2).equals((String)tempUd.get("userRight"))) {
				result.put("userRight", UserRight.LEVEL_2);
				result.put("userRightNm", UserRight.LEVEL_2.getUserRightNm());
			}
		}
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
		int result = 0;
		UserDto udClone = new UserDto(ud);
		Map<String,Object> chekResult = dsaDao.selectUserIdCheck(udClone);
		if ("N".equals(String.valueOf(chekResult.get("uidResult")))) {
			udClone.setUserRight(UserRight.LEVEL_2);
			result = dsaDao.insertUserInfo(udClone);
		}
		return result;
	}
}
