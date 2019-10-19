package servlet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet1.webshop.Products;
import servlet1.webshop.ShoppingCartItem;
import servlet1.webshop.User;

/**
 * Servlet implementation class UkloniServlet
 */
public class UkloniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UkloniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession  session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			
			System.out.println("korisnik nije logovan na sistem ");
			response.sendRedirect("login.html");
			return;
		}
		
		int broj = Integer.parseInt(request.getParameter("scItem"));
		
		
		ArrayList<ShoppingCartItem> korpa = (ArrayList<ShoppingCartItem>) session.getAttribute("korpa");
		
		korpa.remove(broj);
		
response.setContentType("text/html");
		
		PrintWriter pout = response.getWriter();
		
		pout.println("<html>");
		pout.println("<head>");
		pout.println("</head>");
		pout.println("<body>");
		pout.println("<p>");
		pout.println("Stavka je izbrisana");
		pout.println("</p>");

		pout.println("<p>");
		pout.println("<a href=\"ShoppingCartServlet\">Povratak</a>");
		pout.println("</p>");

		pout.println("</body>");
		pout.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
