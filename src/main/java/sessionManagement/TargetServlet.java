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
 * Servlet implementation class TargetServlet
 */
@WebServlet("/targetServlet")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// This TargetServlet will be called when the hyperlink is clicked by the user
	// When a hyperlink is clicked, the browser uses doGet()
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		// By default, whatever is stored in session is of Object type. We will cast it
		// to string as know that we stored string in the session
		String attribute = (String) session.getAttribute("user");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + "User name is : " + attribute + "</h1>");
	}

}
