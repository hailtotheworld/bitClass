package com.newlecture.web.controller;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*


http://localhost:8080/index


 */

public class IndexController implements Controller {

	// 스프링이 제공하고있는 Controller라는 인터페이스 약속을지켜서 handleRequest함수를 구현했고,
	// 모델이라는것을 data라는 이름으로 담아서 index.jsp에 전달한다.
	// 그러면 이제 ModelAndView라는게 반환될거다. 반환되면 디스패처한테 간다.
	// 그러고나면 디스패처가 포워딩해주는거다. 뷰를 찾아서 모델을 전달하는거지.
	// index.jsp는 모델을 출력할때 써가지고 결과물을 사용자에게 전달하는 과정을 만들게 된다.
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		// 지금 이 handleRequest함수에 dispatcher기능은 빠졌다. dispatcher기능은 다 스프링이 제공하고 있다.
		// dispatcher를 하기위한 ModelAndView를 스프링에게 제공해줘야한다. 담아서 주는거다.
		ModelAndView mv = new ModelAndView("index"); // view주소를 ViewResolver를 사용해서 줄였다.
		mv.addObject("data", "Hello Spring MVC~");
		
		// 절대경로
//		mv.setViewName("/WEB-INF/view/index.jsp"); // 메서드로 view주소를 넣어도 되고, 생성자에 넣어도 된다.
		// 주소앞에 /를 붙히면 절대경로가 된다.
		
		// 상대경로
//         mv.setViewName("WEB-INF/view/index.jsp"); // 이렇게 /없이 설정하는건 상대위치에 설정하는거다.
		// <bean id="/aa/index" class="com.newlecture.web.controller.IndexController">  
		// /aa/WEB-INF/view/index.jsp 이렇게 디스패처에서 지정한 위치의 끝과 같은위치로 파악하게된다.
		// /aa/index 같은위치로 파악하는구나..
		
		
		return mv;
	}


}
