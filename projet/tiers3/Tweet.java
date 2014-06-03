package projet.tiers3;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Tweet")
@XmlType(propOrder={"MessageTweet", "NomUtilisateur", "DateHeureTweet"})
@XmlAccessorType (XmlAccessType.FIELD)
public class Tweet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Attributs
	@XmlElement(name="MessageTweet", type=String.class)
	private String MessageTweet;
	@XmlElement(name="NomUtilisateur", type=String.class)
	private String NomUtilisateur;
	@XmlElement(name="DateHeureTweet", type=Date.class)
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
