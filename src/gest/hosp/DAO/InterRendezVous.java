package gest.hosp.DAO;

import java.util.List;

import gest.hosp.web.model.Patient;
import gest.hosp.web.model.RendezVous;

public interface InterRendezVous {
	public List<RendezVous> ListRDV();
	public RendezVous AjouterRDV (RendezVous Rdv);
	public List<RendezVous> ChercherRDV (int id );
	public List<Patient> ListPat();
	public int SupprimerRDV (int id ) ;
	public List<RendezVous> ModifierSelectId (int id) ;
	public int ModifierRdv (RendezVous Rdv);

}
