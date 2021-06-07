package gest.hosp.web.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import gest.hosp.DAO.FactoryDAO;
import gest.hosp.DAO.ImplLogin;
import gest.hosp.web.model.user;



/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FactoryDAO factoryDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
   
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		FactoryDAO factoryDAO = FactoryDAO.getInstance();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		 user User = new user();
		    User.setLogin(login);
		    User.setMdp(password);

	    ImplLogin implLog = new ImplLogin(factoryDAO);
  
	
	
			if(implLog.verifier_user(User)) {

				HttpSession session = request.getSession();
				session.setAttribute("login", login);
				response.sendRedirect("./view/accueil/accueil.jsp");
			}else {
				response.sendRedirect("./view/authentification/authentification.jsp");
			}
		
}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("login");
		response.sendRedirect("./view/authentification/authentification.jsp");
	}

}
