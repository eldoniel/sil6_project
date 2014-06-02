package projet.tiers2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import projet.tiers3.Modele;
import projet.tiers3.Utilisateur;

public class application {

	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry.getRegistry("127.0.0.1",3000);
		Modele modele;
		modele = (Modele) registry.lookup("ModeleService");

		Utilisateur u = new Utilisateur("Test", "supertest");
		
		modele.AjouterUtilisateur(u);
		
		for (int i = 0; i < modele.getListeInscrits().size(); i++) {
			System.out.println(modele.getListeInscrits().get(i).getNomUtilisateur());
		}
	}	
}
