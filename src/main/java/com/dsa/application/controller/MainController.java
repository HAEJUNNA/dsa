package com.dsa.application.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dsa.application.dto.Message;
import com.dsa.application.dto.UserDto;
import com.dsa.application.service.DasService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {
		
	private final DasService dasService;
	
	/**
	 * getDas
	 * ================================
	 * @NAME: 나해준   @DAY: 2023. 9. 16.
	 * ================================
	 * @param param 
	 * @return 
	 * @throws Exception
	 * ================================
	 * @Method : 로그인 메서드
	 * @변경이력 :
	 */
	@PostMapping("/login")
	public ResponseEntity<Message> getDas(UserDto param) throws Exception {
		if (null == param) throw new Exception("파라미터가 존재하지 않습니다.");
		Message msg = new Message();
		UserDto ud = new UserDto();
		ud.setUserId(param.getUserId());
		ud.setUserPass(param.getUserPass());
		Map<String,Object> result = dasService.selectUserIdCheck(ud);
		msg.setData(result);
		return new ResponseEntity<Message>(msg,HttpStatus.OK);
	}
	
	/**
	 * insertUserInfo
	 * ================================
	 * @NAME:나해준    @DAY: 2023. 9. 18.
	 * ================================
	 * @param param
	 * @return
	 * @throws Exception
	 * ================================
	 * @Method : 회원가입 메서드
	 * @변경이력 :
	 */
	@PostMapping("/insertUser")
	public ResponseEntity<Message> insertUserInfo(UserDto param) throws Exception {
		Message msg = new Message();
		UserDto ud = param;
		int result = 0;
		return new ResponseEntity<Message>(msg,HttpStatus.OK);
	}
}
