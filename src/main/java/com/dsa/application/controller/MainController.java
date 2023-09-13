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
