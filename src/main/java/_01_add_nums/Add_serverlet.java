package _01_add_nums;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Add_serverlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res
		.getWriter()
		.append("Sum is ")
		.println(
				Integer.parseInt(req.getParameter("num1"))+
				Integer.parseInt(req.getParameter("num2"))
		);
		
		
	}
}
