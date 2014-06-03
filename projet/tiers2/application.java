package projet.tiers2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;

import projet.tiers3.Modele;
import projet.tiers3.Tweet;
import projet.tiers3.Utilisateur;

public class application {

	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry.getRegistry("127.0.0.1",3000);
		Modele modele;
		modele = (Modele) registry.lookup("ModeleService");

		Utilisateur u = new Utilisateur("idTest", "Test", "supertest");
		
		Tweet t1 = new Tweet("Premier tweet test", "idTest");
		Tweet t2 = new Tweet("Second tweet test", "idTest");
		
		u.AjouterTweet(t1);
		u.AjouterTweet(t2);
		
		modele.AjouterUtilisateur(u);
		
		System.out.println("AJOUT");
		
		for (int i = 0; i < modele.getListeInscrits().size(); i++) {
			System.out.println(modele.getListeInscrits().get(i).getNomUtilisateur());
		}
		
		u = modele.ModifierUtilisateur(u, "NvTest", "Nvsupertest");
		
		System.out.println();
		System.out.println("MODIF");
		
		for (int i = 0; i < modele.getListeInscrits().size(); i++) {
			System.out.println(modele.getListeInscrits().get(i).getNomUtilisateur());
		}
		
		System.out.println();
		
		ControleurImpl ci = new ControleurImpl();
		
		ci.recupListeTweets(modele);
		ArrayList<Tweet> listeTweets = ci.getListeTweets();
		
		for (int i = 0; i < listeTweets.size(); i++) {
			System.out.println(listeTweets.get(i).getIdUtilisateur() + " : " + listeTweets.get(i).getMessageTweet());
		}
		
		System.out.println();
		System.out.println("SUPPR");
		
		modele.SupprimerUtilisateur(u);
		
		for (int i = 0; i < modele.getListeInscrits().size(); i++) {
			System.out.println(modele.getListeInscrits().get(i).getNomUtilisateur());
		}

	}	
}
