package gest.hosp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gest.hosp.web.model.Docteur;
import gest.hosp.web.model.Patient;



public class ImplPatient implements InterPatient{
	FactoryDAO factoryDAO;
	public ImplPatient(FactoryDAO factoryDAO) {
		// TODO Auto-generated constructor stub
		this.factoryDAO= factoryDAO;
	}
	@Override
	public List<Patient> ListPat() {
		// TODO Auto-generated method stub
		Connection con = null;
		List<Patient> listP = new ArrayList<Patient>();
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			String req = "select id_pat,nom_pat,prenom_pat,email_pat,numero_tel_pat,adresse_pat,nom from  patient INNER JOIN docteur ON( patient.id_doc = docteur.id) ";
			 Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(req);
				while(rs.next()){
					int id = rs.getInt("id_pat");
					String nom_pat = rs.getString("nom_pat");
					String prenom = rs.getString("prenom_pat");
					String email = rs.getString("email_pat");
					String numero = rs.getString("numero_tel_pat");
					String adresse = rs.getString("adresse_pat");
					String nom = rs.getString("nom");
					listP.add(new Patient(id,nom_pat,prenom,email,numero,adresse,nom));	
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listP;
		}
	@Override
	public Patient AjouterPat(Patient pat) {
		// TODO Auto-generated method stub
      Connection con = null;	
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			
			 String nom_pat= pat.getNom_pat();
			String prenom= pat.getPrenom();
			 String email=pat.getEmail();
			 String numero=pat.getNumero();
		     String adresse =pat.getAdresse();
			 String nom =pat.getNom();
			 String req = "INSERT INTO patient (nom_pat,prenom_pat,email_pat,numero_tel_pat,adresse_pat,id_doc) values ('"+nom_pat+"','"+prenom+"','"+email+"','"+numero+"','"+adresse+"','"+nom+"')"; 
			 Statement st= con.createStatement();
			 int rs = st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
			 return pat;
	}
	@Override
	public List<Patient> ChercherPat(String prenom, int id) {
		// TODO Auto-generated method stub	
		Connection con = null;
		List<Patient> listP = new ArrayList<Patient>();
		 Statement st;
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			String req = "select * from patient where id_pat='"+id+"'and prenom_pat='"+prenom+"'";
		
				st = con.createStatement();
				ResultSet rs = st.executeQuery(req);
				while(rs.next()){
					Patient pat = new Patient(rs.getInt("id_pat"),rs.getString("nom_pat"), rs.getString("prenom_pat"),rs.getString("email_pat")
							,rs.getString("numero_tel_pat"),rs.getString("adresse_pat"),rs.getString("id_doc"));
					listP.add(pat);		
						
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listP;
	}
	@Override
	public int SupprimerPat(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		 Statement st;
			int b=0;
			
			try {
				FactoryDAO factoryDAO = FactoryDAO.getInstance();
				con = factoryDAO.getConnection();
			
				String req = "delete  from patient where id_pat='"+id+"'";
		
			    st = con.createStatement();
		        b =st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return b;
	}
	@Override
	public List <Docteur>  ListDoc() {
		// TODO Auto-generated method stub
		
		Connection con = null;
		List<Docteur> listD = new ArrayList<Docteur>();
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
		
		String req = "select * from  docteur ";
		 Statement st = con.createStatement();
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
	public List<Patient> ModifierSelectId(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		List<Patient> listP = new ArrayList<Patient>();
	
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			
			String req= "select id_pat,nom_pat,prenom_pat,email_pat,numero_tel_pat,adresse_pat,nom  from  patient INNER JOIN docteur ON(docteur.id=patient.id_doc) where  id_pat='"+id+"'";
			 Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(req);
			while(rs.next()){
				Patient pat = new Patient(rs.getInt("id_pat"),rs.getString("nom_pat"), rs.getString("prenom_pat"),rs.getString("email_pat")
						,rs.getString("numero_tel_pat"),rs.getString("adresse_pat"),rs.getString("nom"));
				listP.add(pat);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listP;
	}
	@Override
	public int ModifierPat(Patient pat) {
		// TODO Auto-generated method stub
		Connection con = null;
		 Statement st;
			int b=0;
			
			try {
				FactoryDAO factoryDAO = FactoryDAO.getInstance();
				con = factoryDAO.getConnection();
				int id = pat.getId();			
				 String nom_pat= pat.getNom_pat();
					String prenom= pat.getPrenom();
					 String email=pat.getEmail();
					 String numero=pat.getNumero();
				     String adresse =pat.getAdresse();
					 String nom =pat.getNom();
				
					 String req = "update patient set nom_pat='"+nom_pat+"',prenom_pat='"+prenom+"', email_pat='"+email+"',numero_tel_pat='"+numero+"',adresse_pat='"+adresse+"',id_doc='"+nom+"' where id_pat='"+id+"'"; 
				st = con.createStatement();
			 b =st.executeUpdate(req);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			return b;
		}

}
