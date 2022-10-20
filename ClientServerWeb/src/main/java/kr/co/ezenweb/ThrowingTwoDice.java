package kr.co.ezenweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThrowingTwoDice {
	
	@RequestMapping("/rollDice")
	public void ezen(HttpServletResponse response) {
		
		int id1 = (int)(Math.random()*6)+1;
		int id2 = (int)(Math.random()*6)+1;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		
		try {
			out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
//			out.println("<h2>주사위 굴리기</h2>");
			out.println("</head>");
			out.println("<body>");
//			int num = (int)(Math.random()*6) + 1;
			out.println("<img src='resources/img/dice"+id1+".jpg' >");
//			int num2 = (int)(Math.random()*6) + 1;
			out.println("<img src='resources/img/dice"+id2+".jpg' >");
			out.println("</body>");
			out.println("</html>");
		} catch (IOException e) {e.printStackTrace();}
		
	}
	
}
