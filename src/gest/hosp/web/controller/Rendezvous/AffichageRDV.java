package gest.hosp.web.controller.Rendezvous;

import java.io.IOException;

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
import gest.hosp.web.model.RendezVous;




/**
 * Servlet implementation class AffichageRDV
 */
@WebServlet("/AffichageRDV")
public class AffichageRDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FactoryDAO factoryDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageRDV() {
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

			if (session.getAttribute("login")== null){
				
				
				response.sendRedirect("./view/authentification/authentification.jsp");
						 
			} else {
				ImplRendezVous implrdv = new ImplRendezVous(factoryDAO);
				List<RendezVous> listRDV = implrdv.ListRDV();
				request.setAttribute("listRDV", listRDV);		
				request.getRequestDispatcher("/view/Rendezvous/AffichageRV.jsp").forward(request,response);
			
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
