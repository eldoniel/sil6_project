package projet.tiers3;

import java.util.ArrayList;

public interface Modele {
	
	public ArrayList<Utilisateur> getListeInscrits();
	
	public void AjouterUtilisateur(Utilisateur UtilAjout);
	
	public void SupprimerUtilisateur(Utilisateur UtilSupp);

}
