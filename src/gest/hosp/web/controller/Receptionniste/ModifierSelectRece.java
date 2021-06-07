package gest.hosp.web.controller.Receptionniste;

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
import gest.hosp.DAO.ImplReceptionniste;
import gest.hosp.web.model.Receptionniste;




/**
 * Servlet implementation class ModifierSelectRece
 */
@WebServlet("/ModifierSelectRece")
public class ModifierSelectRece extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FactoryDAO factoryDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierSelectRece() {
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
		int idd = Integer.parseInt(request.getParameter("id"));
		List<Receptionniste> listRece = new ArrayList<Receptionniste>();
		ImplReceptionniste implrece = new ImplReceptionniste(factoryDAO);
			
			listRece = implrece.ModifierSelectId(idd);
          
               request.setAttribute("listRece", listRece);
              request.getRequestDispatcher("/view/Receptionniste/ModifierRece.jsp").forward(request,response);


               
                }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
