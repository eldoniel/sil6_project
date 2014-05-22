package projet.tiers3;

import java.text.DateFormat;
import java.util.Date;

public class Tweet {

	// Attributs
	private String MessageTweet;
	private String NomUtilisateur;
	private Date DateHeureTweet;
	
	
	// Accesseurs et Modifieurs
	public String getMessageTweet() {
		return MessageTweet;
	}
	
	public void setMessageTweet(String messageTweet) {
		MessageTweet = messageTweet;
	}
	
	public String getNomUtilisateur() {
		return NomUtilisateur;
	}
	
	public void setNomUtilisateur(String nomUtilisateur) {
		NomUtilisateur = nomUtilisateur;
	}
	
	public Date getDateHeureTweet() {
		return DateHeureTweet;
	}
	
	public void setDateHeureTweet(Date dateHeureTweet) {
		DateHeureTweet = dateHeureTweet;
	}

	// Constructeurs
	public Tweet(){
		this.MessageTweet = "";
		this.NomUtilisateur = "";
		this.DateHeureTweet = new Date();
	}
	
	public Tweet(String message, String nomUtil){
		this.MessageTweet = message;
		this.NomUtilisateur = nomUtil;
		this.DateHeureTweet = new Date();
	}
	
	
}
