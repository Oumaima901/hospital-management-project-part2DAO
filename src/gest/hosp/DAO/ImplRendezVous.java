package gest.hosp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gest.hosp.web.model.Patient;
import gest.hosp.web.model.RendezVous;

public class ImplRendezVous implements InterRendezVous {
	FactoryDAO factoryDAO;
	public ImplRendezVous(FactoryDAO factoryDAO) {
		// TODO Auto-generated constructor stub
		this.factoryDAO= factoryDAO;
	}

	@Override
	public List<RendezVous> ListRDV() {
		// TODO Auto-generated method stub
		Connection con = null;
		List<RendezVous> listRDV = new ArrayList<RendezVous>();
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			String req = "select id_RV,date_Rdv,heure_Rdv,nom_pat from  rendezvous INNER JOIN patient ON(rendezvous.id_p = patient.id_pat) ";
			 Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(req);
				while(rs.next()){
					int id = rs.getInt("id_RV");
					String date = rs.getString("date_Rdv");
					String heure = rs.getString("heure_Rdv");
					String nom_pat = rs.getString("nom_pat");
					listRDV.add(new RendezVous(id,date,heure,nom_pat));	
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRDV;
	}

	@Override
	public RendezVous AjouterRDV(RendezVous Rdv) {
		// TODO Auto-generated method stub
		  Connection con = null;	
			try {
				FactoryDAO factoryDAO = FactoryDAO.getInstance();
				con = factoryDAO.getConnection();
				 String date= Rdv.getDate();
				String heure= Rdv.getHeure();
				 String nom_pat=Rdv.getNom_pat();
				 String req = "INSERT INTO rendezvous (date_Rdv,heure_Rdv,id_p) values ('"+date+"','"+heure+"','"+nom_pat+"')";  
				 Statement st= con.createStatement();
				 int rs = st.executeUpdate(req);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				 
				 return Rdv;
		}
	@Override
	public List<RendezVous> ChercherRDV(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		List<RendezVous> listRDV = new ArrayList<RendezVous>();
		 Statement st;
		
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			String req = "select * from rendezvous  where id_RV='"+id+"'";
		
				st = con.createStatement();
				ResultSet rs = st.executeQuery(req);
				while(rs.next()){
					RendezVous rdv = new RendezVous(rs.getInt("id_RV"),rs.getString("date_Rdv"), rs.getString("heure_Rdv"),rs.getString("id_p"));
					
					listRDV.add(rdv);		
						
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listRDV;
	}

	@Override
	public int SupprimerRDV(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		 Statement st;
			int b=0;
			
			try {
				FactoryDAO factoryDAO = FactoryDAO.getInstance();
				con = factoryDAO.getConnection();
			
				String req = "delete  from rendezvous where id_RV='"+id+"'";
		
			    st = con.createStatement();
		        b =st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return b;
	}

	@Override
	public List<Patient> ListPat() {
		// TODO Auto-generated method stub
		Connection con = null;
		List<Patient> listpat = new ArrayList<Patient>();
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
		
			String req = "select * from  patient ";
			 Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(req);
				while(rs.next()){
					int id = rs.getInt("id_pat");
					String nom_pat = rs.getString("nom_pat");
					String prenom = rs.getString("prenom_pat");
					String email = rs.getString("email_pat");
					String numero = rs.getString("numero_tel_pat");
					String adresse = rs.getString("adresse_pat");
					String nom = rs.getString("id_doc");
					listpat.add(new Patient(id,nom_pat,prenom,email,numero,adresse,nom));	
				
				}
				
	       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listpat;
		}

	@Override
	public List<RendezVous> ModifierSelectId(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		List<RendezVous> listRDV = new ArrayList<RendezVous>();
		try {
			FactoryDAO factoryDAO = FactoryDAO.getInstance();
			con = factoryDAO.getConnection();
			String req = "select id_RV,date_Rdv,heure_Rdv,nom_pat from  rendezvous INNER JOIN patient ON(rendezvous.id_p = patient.id_pat)where  id_RV='"+id+"'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(req);
			while(rs.next()){
				RendezVous rdv = new RendezVous(rs.getInt("id_RV"),rs.getString("date_Rdv"), rs.getString("heure_Rdv"),rs.getString("nom_pat"));
				
				listRDV.add(rdv);		
}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRDV;
	}

	@Override
	public int ModifierRdv(RendezVous Rdv) {
		// TODO Auto-generated method stub
		Connection con = null;
		 Statement st;
			int b=0;
			
			try {
				FactoryDAO factoryDAO = FactoryDAO.getInstance();
				con = factoryDAO.getConnection();
				int id = Rdv.getId();		
				 String date= Rdv.getDate();
				 String heure = Rdv.getHeure();
				 String nom_pat = Rdv.getNom_pat();
				 String req = "update rendezvous set date_Rdv ='"+date+"',heure_Rdv ='"+heure+"',id_p='"+nom_pat+"' where id_RV='"+id+"'";
				 st = con.createStatement();
				 b =st.executeUpdate(req);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				
				return b;
			}

}
