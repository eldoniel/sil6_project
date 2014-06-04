package projet.tiers2;

import java.rmi.RemoteException;
import java.util.ArrayList;

import projet.tiers3.Tweet;
import projet.tiers3.Modele;
import projet.tiers3.Utilisateur;

public class ControleurImpl {

	// Attibuts
	private ArrayList<Tweet> listeTweets;
	private ArrayList<Utilisateur> listeUtil;
	
	// Constructeurs
	public ControleurImpl() {
		this.listeTweets = new ArrayList<Tweet>();
		this.listeUtil = new ArrayList<Utilisateur>();
	}

	public ControleurImpl(ArrayList<Tweet> listeTweets, ArrayList<Utilisateur> listeUtil) {
		super();
		this.listeTweets = listeTweets;
		this.listeUtil = listeUtil;
	}
	
	// Accesseurs & Moidifieurs

	public ArrayList<Tweet> getListeTweets() {
		return listeTweets;
	}

	public void setListeTweets(ArrayList<Tweet> listeTweets) {
		this.listeTweets = listeTweets;
	}

	public ArrayList<Utilisateur> getListeUtil() {
		return listeUtil;
	}

	public void setListeUtil(ArrayList<Utilisateur> listeUtil) {
		this.listeUtil = listeUtil;
	}
	
	// Methodes
	public void recupListeTweets(Modele modele) throws RemoteException {
		ArrayList<Utilisateur> listeInscrits = modele.getListeInscrits();
		for (int i=0;i<listeInscrits.size();i++) {
			this.listeTweets.addAll(listeInscrits.get(i).getListeTweets());
		}
	}
	
	public void recupListeUtil(Modele modele) throws RemoteException {
		this.listeUtil = modele.getListeInscrits();
	}
	
	public boolean connexion(String idUtil, String mdpUtil){
		boolean connexion = false;
		Utilisateur Util = getUtilByID(idUtil);
		if (Util != null){
			if (Util.getMDPUtilisateur() == mdpUtil){
				connexion = true;
			}
		}
		return connexion;
	}
	
	public Utilisateur getUtilByID(String idUtil){
		Utilisateur res = null;
		for (int indice = 0; indice < listeUtil.size(); indice++){
			if (listeUtil.get(indice).getIdUtilisateur()==idUtil){
				res = listeUtil.get(indice);
				break;
			}
		}
		return res;
	}
}
