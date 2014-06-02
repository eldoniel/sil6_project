package projet.tiers3;

import java.util.ArrayList;

public class Utilisateur {

	// Attributs
	private String NomUtilisateur;
	private String MDPUtilisateur;
	private ArrayList<Tweet> ListeTweets;
	private ArrayList<String> ListeAbonnes;
	
	// Accesseurs et Modifieurs
	public String getNomUtilisateur() {
		return NomUtilisateur;
	}
	
	public void setNomUtilisateur(String nomUtilisateur) {
		NomUtilisateur = nomUtilisateur;
	}
	
	public String getMDPUtilisateur() {
		return MDPUtilisateur;
	}
	
	public void setMDPUtilisateur(String mDPUtilisateur) {
		MDPUtilisateur = mDPUtilisateur;
	}
	
	public ArrayList<Tweet> getListeTweets() {
		return ListeTweets;
	}
	
	public void AjouterTweet(Tweet TweetAjout){
		this.ListeTweets.add(TweetAjout);
	}
	
	public void SupprimerTweet(Tweet TweetSupp){
		this.ListeTweets.remove(TweetSupp);
	}
	
	public ArrayList<String> getListeAbonnes() {
		return ListeAbonnes;
	}
	
	public void AjouterAbonne(String UtilAjout){
		if (!this.ListeAbonnes.contains(UtilAjout)){
			this.ListeAbonnes.add(UtilAjout);
		}
	}
	
	public void SupprimerAbonne(String UtilSupp){
		this.ListeAbonnes.remove(UtilSupp);
	}

	// Constructeurs
	public Utilisateur() {
		this.NomUtilisateur = "";
		this.MDPUtilisateur = "";
		this.ListeTweets = new ArrayList<Tweet>();
		this.ListeAbonnes = new ArrayList<String>();
	}
	
	public Utilisateur(String nom, String mdp){
		this.NomUtilisateur = nom;
		this.MDPUtilisateur = mdp;
		this.ListeTweets = new ArrayList<Tweet>();
		this.ListeAbonnes = new ArrayList<String>();
	}
}
