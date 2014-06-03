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
	
	public Utilisateur ModifierUtilisateur(Utilisateur UtilModif, String nom, String mdp) throws RemoteException{
		int indice;
		
		for (indice = 0; indice < ListeInscrits.size(); indice++) {
			if((ListeInscrits.get(indice).getNomUtilisateur().equals(UtilModif.getNomUtilisateur())
					&& (ListeInscrits.get(indice).getMDPUtilisateur().equals(UtilModif.getMDPUtilisateur())))){
				ListeInscrits.get(indice).setNomUtilisateur(nom);
				ListeInscrits.get(indice).setMDPUtilisateur(mdp);
				break;
			}
		}
		
		if (indice != ListeInscrits.size()){
			return ListeInscrits.get(indice);
		}
		else{
			return UtilModif;
		}
	}

	public void SupprimerUtilisateur(Utilisateur UtilSupp) throws RemoteException{
		int indice;
		
		for (indice = 0; indice < ListeInscrits.size(); indice++) {
			if((ListeInscrits.get(indice).getNomUtilisateur().equals(UtilSupp.getNomUtilisateur())
					&& (ListeInscrits.get(indice).getMDPUtilisateur().equals(UtilSupp.getMDPUtilisateur())))){
				this.ListeInscrits.remove(indice);
				break;
			}
		}
		
	}

}
