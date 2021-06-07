package gest.hosp.DAO;

import java.util.List;

import gest.hosp.web.model.Docteur;



public interface InterDocteur {
public Docteur AjouterDoc(Docteur doc);
public List<Docteur> ListDoc();
public List<Docteur> ChercherDoc (String nom,int id );
public int SupprimerDoc (int id ) ;
public List<Docteur> ModifierSelectId (int id) ;
public int ModifierDoc (Docteur doc) ;
}
