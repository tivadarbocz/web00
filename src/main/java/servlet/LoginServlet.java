package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		String username = req.getParameter("name");
		String password = req.getParameter("password");

		if(username.equals("admin") && password.equals("admin")){
			req.getRequestDispatcher("profile.html").include(req,resp);

			writer.write("Welcome: " + username);
		}else{
			writer.write("Nem jó a jelszó");

			req.getRequestDispatcher("login.html").include(req, resp);
		}

		writer.close();
	}
}