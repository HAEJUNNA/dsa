package com.dsa.application.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dsa.application.dto.UserDto;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Repository
public class DsaDao {
	
	@Autowired
	private SqlSession sqlSession;

	
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
		Map<String,Object> result = sqlSession.selectOne("selectUserIdCheck", ud);
		return result;
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
}