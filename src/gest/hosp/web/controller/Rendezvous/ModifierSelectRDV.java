package gest.hosp.web.controller.Rendezvous;

import java.io.IOException;
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
import gest.hosp.DAO.ImplRendezVous;
import gest.hosp.web.model.Patient;
import gest.hosp.web.model.RendezVous;





/**
 * Servlet implementation class ModifierSelectRDV
 */
@WebServlet("/ModifierSelectRDV")
public class ModifierSelectRDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FactoryDAO factoryDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierSelectRDV() {
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
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id_RV"));
		List<RendezVous> listRDV = new ArrayList<RendezVous>();
		ImplRendezVous implrdv = new ImplRendezVous(factoryDAO);
		List<Patient> listPat = implrdv.ListPat();
		listRDV= implrdv.ModifierSelectId(id);
			
	
     session.setAttribute("listPat", listPat);
	session.setAttribute("listRDV", listRDV);
	request.getRequestDispatcher("/view/Rendezvous/ModifierRV.jsp").forward(request,response);
	
	
	
}
		
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
