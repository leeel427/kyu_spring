package kr.co.ezenstation;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	
	@RequestMapping(value = {"/req/loginForm.do", "/req/loginForm2.do"}, method = {RequestMethod.GET})
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
			mav.setViewName("/requestmessage/loginForm");
			return mav;
	}
	
	@RequestMapping(value = "/req/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
			
		String requestLine = request.getMethod();			// GET 또는 POST
		requestLine += " " + request.getRequestURI();		// URI-ezenweb/requestmessage
		
		String queryString = request.getQueryString();		// year=2022&month=10&day=13
		requestLine += queryString == null ? "" : "?" + queryString;
		requestLine += " " + request.getProtocol();
		System.out.println(requestLine);
	
		//Request Header
		Enumeration<String> e = request.getHeaderNames();
		
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name+" : "+request.getHeader(name));
		}
		
		// request body -- POST 일 때만 해당, GET은 body가 없음
		final int CONTENT_LENGTH = request.getContentLength();
		System.out.println("Content_length : " + CONTENT_LENGTH);
		
			
		if (CONTENT_LENGTH > 0) {
			try {
				request.setCharacterEncoding("UTF-8");
				mav.setViewName("/requestmessage/result");
				
				String userId = request.getParameter("userID");
				String userName = request.getParameter("username");
				
				mav.addObject("userId", userId);
				mav.addObject("userName", userName);
				
				System.out.println();
				System.out.println("userId = " + userId + "," + "userName = "+ userName);
				
			} catch (UnsupportedEncodingException e1) {e1.printStackTrace();}
		}
		return mav;
		
		
	}

}
