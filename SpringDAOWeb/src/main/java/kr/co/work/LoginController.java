package kr.co.work;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserDAO userDAO;
	
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}

	@PostMapping("/login")
	public String login(String id, String pwd, String toURL, boolean rememberId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

//		System.out.println("id= " + id);
//		System.out.println("pwd= " + pwd);
//		System.out.println("rememberId= " + rememberId);

		// 1. id와 pwd를 확인
		if (!loginCheck(id, pwd)) {
			// 2-1. 일치하지 않으면, loginForm 으로 이동 (redirect)
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "UTF-8");
			return "redirect:/login/login?msg=" + msg;
		}
		// 2-2. 일치하면 로그인 후 화면 (홈화면) 으로 이동

		// 2-2-1. 쿠키를 생성
		// 2-2-2. 응답헤더에 저장
		// 2-3-1. 쿠키를 삭제 cTime=0
		// 2-3-1. 응답헤더에 저장
		if (rememberId) { // 체크 되어 있을시
			Cookie cookie = new Cookie("id", id); // 2-2-1. 쿠키를 생성
			response.addCookie(cookie); // 2-2-2. 응답헤더에 저장
		} else {
			Cookie cookie = new Cookie("id", id); // 체크 해제시
			cookie.setMaxAge(0); // 2-3-1. 쿠키를 삭제 cTime=0
			response.addCookie(cookie); // 2-3-1. 응답헤더에 저장
		}

		// 3. 세션
		// 객체 얻어오기
		HttpSession session = request.getSession();
		// 세션 객체에 id를 저장
		session.setAttribute("id", id);

		// 4. 뷰 이동 (toURL 이 있으면 toURL로 아니면 Home으로)
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;

		return "redirect:" + toURL;
	}

	private boolean loginCheck(String id, String pwd) {
		
		User user = userDAO.selectUser(id);
		if(user == null) return false;
		return user.getPwd().equals(pwd);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 세션을 종료
		session.invalidate();
		// 홈으로 이동
		return "redirect:/";
		
	}
	
	
	
	
	
	
	
}
