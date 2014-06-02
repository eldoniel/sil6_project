package projet.tiers3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Modele extends Remote {
	
	public ArrayList<Utilisateur> getListeInscrits() throws RemoteException;
	
	public void AjouterUtilisateur(Utilisateur UtilAjout) throws RemoteException;
	
	public void SupprimerUtilisateur(Utilisateur UtilSupp) throws RemoteException;
	
	public void SaveToXml() throws Exception;
	
	public void LoadFromXml() throws Exception;

}
