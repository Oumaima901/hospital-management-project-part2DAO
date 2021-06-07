package gest.hosp.DAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gest.hosp.web.model.user;


public class ImplLogin  implements InterLogin{
	FactoryDAO factoryDAO;
	public ImplLogin(FactoryDAO factoryDAO) {
		// TODO Auto-generated constructor stub
		this.factoryDAO= factoryDAO;
	}
	
	@Override
	public boolean verifier_user(user User)  {
		
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       boolean userexist=false;	
try {  
	 
    	   //Assign user entered values to temporary variables.
   		String login= User.getLogin();
   		String mdp=User.getMdp();
		String req = "select * from user where login='"+login+"'and mdp='"+mdp+"'";

		Statement st= con.createStatement();
			ResultSet rs = st.executeQuery(req);
			userexist= rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		return userexist;
	}	

}
	

	

		
		
