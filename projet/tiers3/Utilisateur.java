package projet.tiers3;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Utilisateur")
@XmlType(propOrder={"IdUtilisateur", "NomUtilisateur", "MDPUtilisateur", "ListeTweets", "ListeAbonnements"})
@XmlAccessorType (XmlAccessType.FIELD)
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	// Attributs
	@XmlElement(name="IdUtilisateur", type=String.class)
	private String IdUtilisateur;

	@XmlElement(name="NomUtilisateur", type=String.class)
	private String NomUtilisateur;
	
	@XmlElement(name="MDPUtilisateur", type=String.class)
	private String MDPUtilisateur;
	
	@XmlElementWrapper(name="ListeTweets")
	@XmlElements({
	@XmlElement(name="Tweet")})
	private ArrayList<Tweet> ListeTweets;
	
	@XmlElementWrapper(name="ListeAbonnements")
	@XmlElements({
	@XmlElement(name="Utilisateur")})
	private ArrayList<String> ListeAbonnements;

	// Constructeurs
	public Utilisateur() {
		this.NomUtilisateur = "";
		this.MDPUtilisateur = "";
		this.ListeTweets = new ArrayList<Tweet>();
		this.ListeAbonnements = new ArrayList<String>();
	}
	
	public Utilisateur(String id, String nom, String mdp){
		this.IdUtilisateur = id;
		this.NomUtilisateur = nom;
		this.MDPUtilisateur = mdp;
		this.ListeTweets = new ArrayList<Tweet>();
		this.ListeAbonnements = new ArrayList<String>();
	}
	
	// Accesseurs et Modifieurs
	public String getIdUtilisateur() {
		return IdUtilisateur;
	}
	
	public void setIdUtilisateur(String idUtilisateur) {
		IdUtilisateur = idUtilisateur;
	}
	
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
	
	public ArrayList<String> getListeAbonnements() {
		return ListeAbonnements;
	}
	
	public void AjouterAbonnement(String UtilAjout){
		if (!this.ListeAbonnements.contains(UtilAjout)){
			this.ListeAbonnements.add(UtilAjout);
		}
	}
	
	public void SupprimerAbonnement(String UtilSupp){
		this.ListeAbonnements.remove(UtilSupp);
	}
}
