package projet.tiers2;

import java.rmi.RemoteException;
import java.util.ArrayList;

import projet.tiers3.Modele;
import projet.tiers3.Tweet;

public interface Controleur {

	public void recupListeTweets(Modele modele) throws RemoteException;
	
	public ArrayList<Tweet> getListeTweets() throws RemoteException;
	
	public void setListeTweets(ArrayList<Tweet> listeTweets) throws RemoteException;
	
}
