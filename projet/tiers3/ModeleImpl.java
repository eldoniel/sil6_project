package projet.tiers3;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ModeleImpl implements Modele {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Utilisateur> ListeInscrits;

	protected ModeleImpl() throws RemoteException {
		super();
		ListeInscrits = new ArrayList<Utilisateur>();
	}

	

	// Methodes
	public ArrayList<Utilisateur> getListeInscrits()  throws RemoteException{
		return ListeInscrits;
	}

	public void AjouterUtilisateur(Utilisateur UtilAjout) throws RemoteException{
		System.out.println(UtilAjout.getNomUtilisateur());
		if(!this.ListeInscrits.contains(UtilAjout)){
			this.ListeInscrits.add(UtilAjout);
		}
	}

	public void SupprimerUtilisateur(Utilisateur UtilSupp) throws RemoteException{
		this.ListeInscrits.remove(UtilSupp);
	}

}
