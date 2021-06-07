package gest.hosp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gest.hosp.web.model.Receptionniste;


public class ImplReceptionniste implements InterReceptionniste{
	FactoryDAO factoryDAO;
	public ImplReceptionniste(FactoryDAO factoryDAO) {
		// TODO Auto-generated constructor stub
		this.factoryDAO= factoryDAO;
	}
	@Override
	public Receptionniste AjouterRece(Receptionniste rece) {
		// TODO Auto-generated method stub
Connection con = null;
		
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			 String nom= rece.getNom();
			String prenom= rece.getPrenom();
			 String email=rece.getEmail();
		     String numero=rece.getNumero();
			 String adresse=rece.getAdresse();
			 String req = "INSERT INTO receptionnistes (nom, prenom, email, numero_tel, adresse) values ('"+nom+"','"+prenom+"','"+email+"','"+numero+"','"+adresse+"')"; 
			 Statement st= con.createStatement();
			 int rs = st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rece;
	}
	@Override
	public List<Receptionniste> ListRecep() {
		// TODO Auto-generated method stub
		Connection con = null;
		List<Receptionniste> listRece = new ArrayList<Receptionniste>();
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			String req = "select * from  receptionnistes ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(req);
			while(rs.next()){
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String numero = rs.getString("numero_tel");
				String adresse = rs.getString("adresse");
				listRece.add(new Receptionniste(id,nom,prenom,email,numero,adresse));	
			
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return listRece;
			}
	@Override
	public List<Receptionniste> ChercherRece(String nom, int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		List<Receptionniste> listRece = new ArrayList<Receptionniste>();
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			String req = "select * from receptionnistes where id='"+id+"'and nom='"+nom+"'";
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(req);
			
				while(rs.next()){
					Receptionniste  rece = new Receptionniste(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("email")
							,rs.getString("numero_tel"),rs.getString("adresse"));
					listRece.add(rece);
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
		return listRece;
	}
	@Override
	public int SupprimerRece(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		 Statement st;
			int b=0;
			
			try {
				FactoryDAO factoryDAO = FactoryDAO.getInstance();
				con = factoryDAO.getConnection();
				String req = "delete  from receptionnistes where id='"+id+"'";
				st = con.createStatement();
				 b =st.executeUpdate(req);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				
				return b;
	}
	@Override
	public List<Receptionniste> ModifierSelectId(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		List<Receptionniste> listRece = new ArrayList<Receptionniste>();
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			String req= "SELECT * FROM receptionnistes where id='"+id+"'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(req);
			while(rs.next()){
				Receptionniste  rece = new Receptionniste(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("email")
						,rs.getString("numero_tel"),rs.getString("adresse"));
				listRece.add(rece);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return listRece;
	}
	@Override
	public int ModifierRece(Receptionniste rece) {
		// TODO Auto-generated method stub
		Connection con = null;
		 Statement st;
			int b=0;
			
			try {
				FactoryDAO factoryDAO = FactoryDAO.getInstance();
				con = factoryDAO.getConnection();
				int id = rece.getId();
				 String nom= rece.getNom();
					String prenom= rece.getPrenom();
					 String email=rece.getEmail();
				     String numero =rece.getNumero();
					 String adresse=rece.getAdresse();
					 String req = "update receptionnistes set nom='"+nom+"',prenom='"+prenom+"', email='"+email+"',numero_tel='"+numero+"',adresse='"+adresse+"' where id='"+id+"'";
						st = con.createStatement();
						 b =st.executeUpdate(req);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						
						
						return b;
					}
}