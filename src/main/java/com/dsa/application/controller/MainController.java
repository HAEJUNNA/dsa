package com.dsa.application.controller;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/main")
public class MainController {
		
	
	@Autowired
	DasService dasService;
	
	@PostMapping("/login")
	public ResponseEntity<Message> getDas(@RequestBody UserDto param) throws Exception {
		Message msg = new Message();
		UserDto ud = new UserDto();
		ud.setUserId(param.getUserId());
		ud.setUserPass(param.getUserPass());
		Map<String,Object> result = dasService.selectUserIdCheck(ud);
		msg.setData(result);
		return new ResponseEntity<Message>(msg,HttpStatus.OK);
	}
	
	@PostMapping("/insertUser")
	public ResponseEntity<Message> insertUserInfo(@RequestBody UserDto param) throws Exception {
		Message msg = new Message();
		UserDto ud = param;
		int result = 0;
		return new ResponseEntity<Message>(msg,HttpStatus.OK);
	}
}
