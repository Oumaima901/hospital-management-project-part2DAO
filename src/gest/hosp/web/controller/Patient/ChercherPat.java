package gest.hosp.web.controller.Patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gest.hosp.DAO.FactoryDAO;
import gest.hosp.DAO.ImplPatient;
import gest.hosp.web.model.Patient;



/**
 * Servlet implementation class ChercherPat
 */
@WebServlet("/ChercherPat")
public class ChercherPat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FactoryDAO factoryDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChercherPat() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		FactoryDAO factoryDAO = FactoryDAO.getInstance();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	
		String prenom= request.getParameter("txtnompat");
		int id = Integer.parseInt(request.getParameter("txtid"));

		HttpSession session = request.getSession();
		
		if(session.getAttribute("login")==null){
			response.sendRedirect("./view/accueil/accueil.jsp");}
		else {
			ImplPatient implpat = new ImplPatient(factoryDAO);
			
			List<Patient> listP = implpat.ChercherPat(prenom, id);
				request.setAttribute("listP", listP);
		
				request.getRequestDispatcher("./view/Patient/AffichageP.jsp").forward(request, response);
					
			
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
