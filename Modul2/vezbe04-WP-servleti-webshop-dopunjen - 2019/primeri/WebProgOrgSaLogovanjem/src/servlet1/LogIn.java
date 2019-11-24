package servlet1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet1.webshop.User;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ArrayList<User> users = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		users = new ArrayList<User>();
		users.add(new User("pera", "peric"));
		users.add(new User("steva", "stevic"));
		users.add(new User("jova", "jovic"));
		users.add(new User("mitar", "miric"));
		users.add(new User("peka", "peka"));
		getServletContext().setAttribute("users", users);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user")!=null) {
			response.sendRedirect("WebShopServlet");
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username==null || username.equals("")) {
			response.sendRedirect("login.html");
			return;
		}
		// boolean validUser = false;
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				// validUser = true;
				// response.sendRedirect("registracijaBezCSS.html");
				session.setAttribute("user", user);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WebShopServlet");
				requestDispatcher.forward(request, response);
				// break;
				return;
			}
		}
		// if(!validUser){
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
		requestDispatcher.forward(request, response);
		// response.sendRedirect("inputUser.html");
		// }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
