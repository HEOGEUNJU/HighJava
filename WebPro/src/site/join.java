package site;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public join() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession(false);
		session.setAttribute("joinCode", "yes");
		
		
		//결과를 처리하고 응답데이터를 담은 객체를 view페이지로 보내줘야함.
		RequestDispatcher disp = request.getRequestDispatcher("site/index.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
