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
 * Servlet implementation class ChercherRece
 */
@WebServlet("/ChercherRece")
public class ChercherRece extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FactoryDAO factoryDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChercherRece() {
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
		
		String nom= request.getParameter("txtprenomdoc");
		int id = Integer.parseInt(request.getParameter("txtid"));
		//creation session
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login")==null){
			response.sendRedirect("./view/accueil/accueil.jsp");}
		else {
			ImplReceptionniste implrece = new ImplReceptionniste(factoryDAO);
			List<Receptionniste> listRece = new ArrayList<Receptionniste>();
			listRece = implrece.ChercherRece(nom, id);
			
			request.setAttribute("listRece", listRece);
			
			request.getRequestDispatcher("./view/Receptionniste/AffichageRece.jsp").forward(request, response);
			
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
