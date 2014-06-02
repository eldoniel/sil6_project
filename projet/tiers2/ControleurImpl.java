package projet.tiers2;

import java.rmi.RemoteException;
import java.util.ArrayList;

import projet.tiers3.Tweet;
import projet.tiers3.Modele;
import projet.tiers3.Utilisateur;

public class ControleurImpl {
	
	public ControleurImpl() {
		this.listeTweets = new ArrayList();
	}

	public ControleurImpl(ArrayList<Tweet> listeTweets) {
		super();
		this.listeTweets = listeTweets;
	}

	private ArrayList<Tweet> listeTweets;
	
	public void recupListeTweets(Modele modele) throws RemoteException {
		ArrayList<Utilisateur> listeInscrits = modele.getListeInscrits();
		for (int i=0;i<listeInscrits.size();i++) {
			this.listeTweets.addAll(listeInscrits.get(i).getListeTweets());
		}
	}

	public ArrayList<Tweet> getListeTweets() {
		return listeTweets;
	}

	public void setListeTweets(ArrayList<Tweet> listeTweets) {
		this.listeTweets = listeTweets;
	}
	
}
