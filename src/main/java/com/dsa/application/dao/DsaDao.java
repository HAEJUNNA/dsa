package com.dsa.application.dao;

import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dsa.application.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DsaDao {
	
	private final SqlSession sqlSession;

	
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
	public Map<String,Object> selectUserIdCheck(UserDto ud) {
		return sqlSession.selectOne("selectUserIdCheck", ud);
	}
	
	/**
	 * selectUserIdDuplicationCheck
	 * ================================
	 * @NAME:나해준    @DAY: 2023. 8. 27.
	 * ================================
	 * @param ud[userId(사용자id)]
	 * @return 아이디 중복체크 결과
	 * @throws Exception
	 * ================================
	 * @Method : 해당 id로 가입되어있는지 체크한다.
	 * @변경이력 :
	 */
	public Map<String,Object> selectUserIdDuplicationCheck(UserDto ud) {
		return sqlSession.selectOne("selectUserIdDuplicationCheck",ud);
	}
	
	/**
	 * insertUserInfo
	 * ================================
	 * @NAME:나해준    @DAY: 2023. 9. 20.
	 * ================================
	 * @param ud
	 * @return
	 * ================================
	 * @Method : 유저정보 저장
	 * @변경이력 :
	 */
	public int insertUserInfo(UserDto ud) {
		return sqlSession.insert("insertUserInfo", ud);
	}
}