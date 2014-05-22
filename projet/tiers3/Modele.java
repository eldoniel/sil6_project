package projet.tiers3;

import java.util.ArrayList;

public class Modele {

	private ArrayList<Utilisateur> ListeInscrits;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Utilisateur> getListeInscrits() {
		return ListeInscrits;
	}
	
	public void AjouterUtilisateur(Utilisateur UtilAjout){
		if(!this.ListeInscrits.contains(UtilAjout)){
			this.ListeInscrits.add(UtilAjout);
		}
	}
	
	public void SupprimerUtilisateur(Utilisateur UtilSupp){
		this.ListeInscrits.remove(UtilSupp);
	}

}
