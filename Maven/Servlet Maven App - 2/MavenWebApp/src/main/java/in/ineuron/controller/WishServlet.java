package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.ineuron.MathApp; // importing from jar

@WebServlet("/wish")
public class WishServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		LocalDateTime dt = LocalDateTime.now();
		int hour = dt.getHour();
		pw.println("<h1><center>Today date and time is :: " + dt + "</center></h1>");
		if (hour < 12)
			pw.println("<h2><center>Good Morning </center></h2>");
		else if (hour < 16)
			pw.println("<h2><center>Good Afternoon</center></h2>");
		else if (hour < 20)
			pw.println("<h2><center>Good Evening</center></h2>");
		else
			pw.println("<h2><center>Good night</center></h2>");
		
		// reuring code from MathProj1
		MathApp m = new MathApp();
		int sum =m.add(10,67);
		pw.println("<h1> Re-used codes from MathProj1</h1>");
		pw.println("<h1> Sum is: "+sum+"</h1>");

		pw.close();

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}