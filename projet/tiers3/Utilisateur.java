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
@XmlType(propOrder={"NomUtilisateur", "MDPUtilisateur", "ListeTweets", "ListeAbonnes"})
@XmlAccessorType (XmlAccessType.FIELD)
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	// Attributs
	@XmlElement(name="NomUtilisateur", type=String.class)
	private String NomUtilisateur;
	
	@XmlElement(name="MDPUtilisateur", type=String.class)
	private String MDPUtilisateur;
	
	@XmlElementWrapper(name="ListeTweets")
	@XmlElements({
	@XmlElement(name="Tweet")})
	private ArrayList<Tweet> ListeTweets;
	
	@XmlElementWrapper(name="ListeAbonnes")
	@XmlElements({
	@XmlElement(name="Utilisateur")})
	private ArrayList<String> ListeAbonnes;

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
}
