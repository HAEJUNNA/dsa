/**
 * 
 */
package com.dsa.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * vue.js는 SPA방식으로 구성했기때문에 그냥 주소를 새로고침하거나 직접 주소를 작성해서 이동할경우 오류페이지가 발생하여
 * 해당 페이지를 찾지못하는 오류가 발생시 기본 index.html로 리다이렉트할수있도록 해주는 컨트롤러 
 * 이렇게만 해서 작업이 끝나느게 아니라 vue.js 에서도 똑같이 해당 페이지로 매핑됐을때 보여줄 에러 페이지를 구성해야한다.
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
	// error path를 꼭 "/error" 로 하자!
	private final String ERROR_PATH = "/error";
	
	@GetMapping(ERROR_PATH)
	public String redirectRoot(){
	    return "index.html";
	}
	
	public String getErrorPath(){
	    return null;
	}
}
