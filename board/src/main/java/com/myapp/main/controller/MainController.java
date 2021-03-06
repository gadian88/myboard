package com.myapp.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//메인화면
@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index() throws Exception{
		

    	return main();
	}
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public ModelAndView main() throws Exception{
		
		//모델겍체 생성
    	ModelAndView modelandview = new ModelAndView("main");
    	return modelandview;
	}
	
	//권한페이지 - AccessDinied
	@RequestMapping(value="/403", method={RequestMethod.GET,RequestMethod.POST})
	public String error403() {
	    return "/error/403";
	}
	
}
