package servlet1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet1.webshop.User;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<User> users; 
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username == null || password == null ||
				username.trim().equals("") || password.trim().equals("")) {
			
			System.out.println("nevalidan unos username or password");
			response.sendRedirect("login.html");
			return; //zavrsetak metode da se kod ne bi nastavio sa izvrsavanjem
		}
		
		username = username.trim();
		password = password.trim();
		
		HttpSession  session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user !=null) {
			
			System.out.println("korisnik je vec logovan kao: " + user.getUsername());
			response.sendRedirect("WebShopServlet");
			return;
		}
		
		for (User temp: users) {
			
			if (temp.getUsername().equals(username) && temp.getPassword().equals(password)) {
				user=temp;
				session.setAttribute("user", user);
				response.sendRedirect("WebShopServlet");
				return;
			}
					
		}
		
		System.out.println("netacni podaci za logovanje");
		response.sendRedirect("login.html");
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
