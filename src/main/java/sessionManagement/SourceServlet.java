package sessionManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SourceServlet
 */
@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
			}
		}

		// adding cookie on the response from server
		response.addCookie(new Cookie("securityToken", "12345"));

		String userName = request.getParameter("userName");

		// To retrieve the particular session associated with this request
		HttpSession session = request.getSession();

		// Setting name value pair on the session object
		session.setAttribute("user", userName);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		// sending the control to target servlet. it will also transfer the session
		// object implying that the process is under one session

		/*
		 * out.print("<body>" + "<a href='targetServlet'>Click here to get the user
		 * name</a>" + "</body>");
		 */

		// url rewriting, although the session id in url is hard coded
		String url = "targetServlet?sessionId=123";
		out.print("<body>" + "<a href='" + url + "'>Click here to get the user name</a>" + "</body>");

		// Hidden form field example
		/*
		 * out.print("<form action='targetServlet'>");
		 * out.print("<input type='hidden' name='username' value='" + userName + "'>");
		 * out.print("<input type='submit' value='submit'>"); out.print("</form>");
		 */

	}

}
