package projet.tiers3;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ModeleImpl extends UnicastRemoteObject{

	private static final long serialVersionUID = 1L;

	protected ModeleImpl() throws RemoteException {
		super();
	}

	private ArrayList<Utilisateur> ListeInscrits;

	// Methodes
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
