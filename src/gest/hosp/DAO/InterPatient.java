package gest.hosp.DAO;

import java.util.List;

import gest.hosp.web.model.Docteur;
import gest.hosp.web.model.Patient;


public interface InterPatient {
	public List<Patient> ListPat();
	public Patient AjouterPat(Patient pat);
	public List<Patient> ChercherPat (String prenom,int id );
	public int SupprimerPat (int id ) ;
	public List<Docteur> ListDoc();
	public List<Patient> ModifierSelectId (int id) ;
	public int ModifierPat (Patient pat);
}
