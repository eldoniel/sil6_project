package projet.tiers2;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import projet.tiers3.Modele;
import projet.tiers3.Tweet;
import projet.tiers3.Utilisateur;

@WebService
public interface Controleur {

	@WebMethod
	public void recupListeTweets(Modele modele) throws RemoteException;
	
	@WebMethod
	public ArrayList<Tweet> getListeTweets() throws RemoteException;
	
	@WebMethod
	public void setListeTweets(ArrayList<Tweet> listeTweets) throws RemoteException;
	
	@WebMethod
	public boolean connexion(String idUtil, String mdpUtil);
	
	@WebMethod
	public Utilisateur getUtilByID(String idUtil);
	
}
