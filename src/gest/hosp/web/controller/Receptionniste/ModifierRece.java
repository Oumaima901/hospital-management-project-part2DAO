package gest.hosp.web.controller.Receptionniste;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gest.hosp.DAO.FactoryDAO;
import gest.hosp.DAO.ImplReceptionniste;
import gest.hosp.web.model.Receptionniste;


/**
 * Servlet implementation class ModifierRece
 */
@WebServlet("/ModifierRece")
public class ModifierRece extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FactoryDAO factoryDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierRece() {
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
	
		int id = Integer.parseInt(request.getParameter("txtid"));
		String nom = request.getParameter("txtnom");
		String prenom = request.getParameter("txtprenom");
		String email = request.getParameter("email");
		String numero = request.getParameter("numero");
		String adresse = request.getParameter("txtadresse");
	
			HttpSession session = request.getSession();
			if(session.getAttribute("login")==null){
				response.sendRedirect("./view/accueil/accueil.jsp");}
			else {
				
					ImplReceptionniste implrece = new ImplReceptionniste(factoryDAO);
					Receptionniste rece = new Receptionniste(id,nom,prenom,email,numero,adresse);
					int b = implrece.ModifierRece(rece);
					response.sendRedirect("./AffichageRece");
				
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
