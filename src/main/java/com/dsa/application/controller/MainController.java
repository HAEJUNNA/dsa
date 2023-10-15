package com.dsa.application.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.application.dto.Message;
import com.dsa.application.dto.UserDto;
import com.dsa.application.entity.User;
import com.dsa.application.service.DasService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

//@Controller 스프링 컨테이너가 처음에 뜰때 해당 어노테이션으로 명명한 
// 컨트롤러 객체를 만들어서 컨테이너에 넣어서 스프링이 알아서 관리
// 원래는 @Compnent 스캔으로 의존성 주입하는것이다. 
// @Autowired는 스프링 컨테이너에 올라가있는 객체들의 연관관계를 매핑해주는 역할(의존성주입)
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {
	// 의존성 주입방식
	// 생성자 주입방식
	private final DasService dasService;
	
// 생성자 주입방식 (수동)
//	private DasService dasService;
//	
//	@Autowired
//	public MainController(DasService dasService) {
//		this.dasService = dasService;
//	};
	
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
	public ResponseEntity<Message> getDas(@RequestBody User param) throws Exception {
		if (null == param) throw new Exception("파라미터가 존재하지 않습니다.");
		Message msg = new Message();
		User user = User.builder()
				.userId(param.getUserId())
				.userPass(param.getUserPass())
				.build();
		Map<String,Object> result = dasService.selectUserIdCheck(user);
		msg.setData(result);
		return new ResponseEntity<Message>(msg,HttpStatus.OK);
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
	@PostMapping("/usrCheck")
	public ResponseEntity<Message> selectChekUserInfo(@RequestBody Map<String,Object> param) throws Exception {
		Message msg = new Message();
		UserDto ud = new UserDto();
		Map<String,Object> result = new HashMap<>();
		if (null == param) {
			msg.setStatus(HttpStatus.NOT_FOUND);
		} else {
			ud.setUserId((String)param.get("userId"));
			result = dasService.selectChekUserInfo(ud);
			if (result !=null) {
				msg.setData(result);
				msg.setStatus(HttpStatus.OK);
			} else {
				msg.setStatus(HttpStatus.NOT_FOUND);			
				msg.setMessage("회원정보가 존재하지 않습니다.");			
			}			
		}
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
	public ResponseEntity<Message> insertUserInfo(@RequestBody User user) throws Exception {
		Message msg = new Message();
		User ud = user;
		log.debug(ud);
		int result = dasService.insertUserInfo(user);
		if (result == 1) {
			msg.setMessage("회원가입이 완료되었습니다.");
			msg.setStatus(HttpStatus.OK);
		} else {
			msg.setMessage("회원가입이 완료되지 않았습니다.");
			msg.setStatus(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Message>(msg,HttpStatus.OK);
	}
}
