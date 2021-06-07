package gest.hosp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gest.hosp.web.model.Docteur;


public class ImplDocteur implements InterDocteur{
	FactoryDAO factoryDAO;
	public ImplDocteur(FactoryDAO factoryDAO) {
		// TODO Auto-generated constructor stub
		this.factoryDAO= factoryDAO;
	}
	@Override
	public Docteur AjouterDoc(Docteur doc) {
		// TODO Auto-generated method stub
		Connection con = null;
		
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			
			 String nom= doc.getNom();
			String prenom= doc.getPrenom();
			 String email=doc.getEmail();
			 String specialisation=doc.getSpecialisation();
		     String numero=doc.getNumero();
			 String adresse=doc.getAdresse();
			 String req = "INSERT INTO docteur (nom, prenom, email, specialisation, numero_tel, adresse) values ('"+nom+"','"+prenom+"','"+email+"','"+specialisation+"','"+numero+"','"+adresse+"')";
			 Statement st= con.createStatement();
			 int rs = st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return doc;
	}
	@Override
	public List <Docteur>  ListDoc() {
		// TODO Auto-generated method stub
		
		Connection con = null;
		List<Docteur> listD = new ArrayList<Docteur>();
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String req = "select * from  docteur ";
		 Statement st;
		 
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(req);
			
			while(rs.next()){
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String specialisation = rs.getString("specialisation");
				String numero = rs.getString("numero_tel");
				String adresse = rs.getString("adresse");
				listD.add(new Docteur(id,nom,prenom,email,specialisation,numero,adresse));	
			
			}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listD;
		}
	@Override
	public List<Docteur> ChercherDoc(String nom,int id) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		List<Docteur> listD = new ArrayList<Docteur>();
		 Statement st;
	
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String req = "select * from docteur where id='"+id+"'and prenom='"+nom+"'";
		 
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(req);
			while(rs.next()){
				Docteur doc = new Docteur(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("email"),rs.getString("specialisation")
						,rs.getString("numero_tel"),rs.getString("adresse"));
				listD.add(doc);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listD;
	}
	@Override
	public int SupprimerDoc(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		 Statement st;
			int b=0;
			
			try {
				FactoryDAO factoryDAO = FactoryDAO.getInstance();
				con = factoryDAO.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String req = "delete  from docteur where id='"+id+"'";
		try {
			st = con.createStatement();
		 b =st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return b;
	}
	@Override
	public List<Docteur> ModifierSelectId(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		List<Docteur> listD = new ArrayList<Docteur>();
		 Statement st;
	
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String req= "SELECT * FROM docteur where id='"+id+"'";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(req);
			while(rs.next()){
				Docteur doc = new Docteur(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("email"),rs.getString("specialisation")
						,rs.getString("numero_tel"),rs.getString("adresse"));
				listD.add(doc);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return listD;
	}
	@Override
	public int ModifierDoc(Docteur doc) {
		// TODO Auto-generated method stub
		Connection con = null;
		 Statement st;
			int b=0;
			
			try {
				FactoryDAO factoryDAO = FactoryDAO.getInstance();
				con = factoryDAO.getConnection();
				int id = doc.getId();
				 String nom= doc.getNom();
					String prenom= doc.getPrenom();
					 String email=doc.getEmail();
					 String specialisation=doc.getSpecialisation();
				     String numero =doc.getNumero();
					 String adresse=doc.getAdresse();
		 String req = "update docteur set nom='"+nom+"',prenom='"+prenom+"', email='"+email+"',specialisation='"+specialisation+"',numero_tel='"+numero+"',adresse='"+adresse+"' where id='"+id+"'";	 
				st = con.createStatement();
			 b =st.executeUpdate(req);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			return b;
		}
}
