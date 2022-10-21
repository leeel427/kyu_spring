package kr.co.ezenred;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingTest {
	
	@RequestMapping({"/login/hello.do", "/login/hi.do"})
	public void test1() {
		System.out.println("URLpatter=/login/hello.do");
	}

	@RequestMapping("/login/*")
	public void test2() {
		System.out.println("URLpatter=/login/*");
	}
	
	@RequestMapping("/login/**/temp/*.do")
	public void test3() {
		System.out.println("URLpatter=/login/**/temp/*.do");
	}	
	
	@RequestMapping("/login/??")
	public void test4() {
		System.out.println("URLpatter=/login/??");
	}		
	
	@RequestMapping("*.do")
	public void test5() {
		System.out.println("URLpatter=*.do");
	}	
	
	@RequestMapping("/*.???")
	public void test6() {
		System.out.println("URLpatter=/*.???");
	}	
	
	
	
}
