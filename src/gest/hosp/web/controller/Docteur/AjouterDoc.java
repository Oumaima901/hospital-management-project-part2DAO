package gest.hosp.web.controller.Docteur;

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
import gest.hosp.DAO.ImplDocteur;
import gest.hosp.web.model.Docteur;



/**
 * Servlet implementation class AjouterDoc
 */
@WebServlet("/AjouterDoc")
public class AjouterDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FactoryDAO factoryDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterDoc() {
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
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String nom = request.getParameter("txtnom");
		String prenom = request.getParameter("txtprenom");
		String email = request.getParameter("email");
		String specialisation = request.getParameter("txtspec");
		String numero = request.getParameter("numero");
		String adresse = request.getParameter("txtadresse");
		//creation session
		HttpSession session = request.getSession();

		if(session.getAttribute("login")==null){
			response.sendRedirect("./view/accueil/accueil.jsp");}
		else {
			   ImplDocteur impldoc = new ImplDocteur(factoryDAO);
			   Docteur doc = new Docteur(nom,prenom,email,specialisation,numero,adresse);
			 doc= impldoc.AjouterDoc(doc);
				
				out.print("Docteur ajouter avec success");
				out.print("<a href='./AffichageDoc'>voir la liste</a>");
				
				
			
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
