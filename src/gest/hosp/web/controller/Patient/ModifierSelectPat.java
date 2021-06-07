package gest.hosp.web.controller.Patient;

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
import gest.hosp.DAO.ImplPatient;
import gest.hosp.web.model.Docteur;
import gest.hosp.web.model.Patient;



/**
 * Servlet implementation class ModifierSelectPat
 */
@WebServlet("/ModifierSelectPat")
public class ModifierSelectPat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FactoryDAO factoryDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierSelectPat() {
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
	
		int id = Integer.parseInt(request.getParameter("id_pat"));
		List<Docteur> listDoc = new ArrayList<Docteur>();
		
		ImplPatient implpat = new ImplPatient(factoryDAO);
		listDoc=implpat.ListDoc();
	
		
		List<Patient> listpa = implpat.ModifierSelectId(id);

	     request.setAttribute("listDoc", listDoc);
               session.setAttribute("listpa", listpa);
              request.getRequestDispatcher("/view/Patient/ModifierP.jsp").forward(request,response);


              
                }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
