package gest.hosp.DAO;

import java.util.List;

import gest.hosp.web.model.Receptionniste;


public interface InterReceptionniste {
	public Receptionniste AjouterRece(Receptionniste rece);
	public List<Receptionniste> ListRecep();
	public List<Receptionniste> ChercherRece (String nom,int id );
	public int SupprimerRece (int id ) ;
	public List<Receptionniste> ModifierSelectId (int id) ;
	public int ModifierRece (Receptionniste rece) ;
	}