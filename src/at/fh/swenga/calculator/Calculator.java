package at.fh.swenga.calculator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/calc")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num1Param = request.getParameter("num1");
		String num2Param = request.getParameter("num2");

		try {
			int num1 = Integer.parseInt(num1Param); // Wrapperclass
			int num2 = Integer.parseInt(num2Param);

			int result = num1 + num2;

			request.setAttribute("result", result);

			RequestDispatcher rq = request.getRequestDispatcher("./showResult.jsp");
			
			rq.forward(request, response);
			
			return; // explicitly return value

		} catch (Exception e) { //Exception aller Exceptions
			e.printStackTrace(); // useful for debugging
			request.setAttribute("error", "Dea wos samsing rong " + e.getMessage());
			RequestDispatcher rq = request.getRequestDispatcher("./showError.jsp");
			rq.forward(request, response);
		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
