package gest.hosp.web.controller.Rendezvous;

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
import gest.hosp.DAO.ImplRendezVous;
import gest.hosp.web.model.RendezVous;



/**
 * Servlet implementation class ModifierRDV
 */
@WebServlet("/ModifierRDV")
public class ModifierRDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FactoryDAO factoryDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierRDV() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int id= Integer.parseInt(request.getParameter("txtid"));
		String date = request.getParameter("txtdate");
		String heure = request.getParameter("txtheure");
		String nom_pat = request.getParameter("txtpat");
	
	
			HttpSession session = request.getSession();
			if(session.getAttribute("login")==null){
				response.sendRedirect("./view/accueil/accueil.jsp");}
			else {
				ImplRendezVous implrdv = new ImplRendezVous(factoryDAO);
				RendezVous Rdv = new RendezVous(id,date,heure,nom_pat);
				int b=implrdv.ModifierRdv(Rdv);
				
				 response.sendRedirect("./AffichageRDV");
				
			
			
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
