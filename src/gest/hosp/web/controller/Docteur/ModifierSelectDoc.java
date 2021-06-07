package gest.hosp.web.controller.Docteur;

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

import gest.hosp.DAO.FactoryDAO;
import gest.hosp.DAO.ImplDocteur;
import gest.hosp.web.model.Docteur;



/**
 * Servlet implementation class ModifierSelectDoc
 */
@WebServlet("/ModifierSelectDoc")
public class ModifierSelectDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	FactoryDAO factoryDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierSelectDoc() {
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
		int idd = Integer.parseInt(request.getParameter("id"));
	
			
			
            List<Docteur> listD = new ArrayList<Docteur>();

            ImplDocteur impldoc = new ImplDocteur(factoryDAO);
	        listD = impldoc.ModifierSelectId(idd);

               request.setAttribute("listD", listD);
              request.getRequestDispatcher("/view/docteur/ModifierD.jsp").forward(request,response);
              
                }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
