package projet.tiers1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import projet.tiers2.ControleurImpl;
import projet.tiers3.Modele;
import projet.tiers3.Tweet;
import projet.tiers3.Utilisateur;

public class Client {
	public static void main(String[] args) throws Exception {
		
		Utilisateur u1 = new Utilisateur("u1", "utilisateur1", "mdp1");
		Utilisateur u2 = new Utilisateur("u2", "utilisateur2", "mdp2");
		Utilisateur u3 = new Utilisateur("u3", "utilisateur3", "mdp3");
		Utilisateur u4 = new Utilisateur("u4", "utilisateur4", "mdp4");
		Utilisateur u5 = new Utilisateur("u5", "utilisateur5", "mdp5");
		
		Tweet t1 = new Tweet("Tweet1","u1");
		Tweet t2 = new Tweet("Tweet2","u1");
		Tweet t3 = new Tweet("Tweet3","u5");
		Tweet t4 = new Tweet("Tweet4","u3");
		Tweet t5 = new Tweet("Tweet5","u3");
		Tweet t6 = new Tweet("Tweet6","u4");
		Tweet t7 = new Tweet("Tweet7","u2");
		Tweet t8 = new Tweet("Tweet8","u5");
		Tweet t9 = new Tweet("Tweet9","u4");
		Tweet t10 = new Tweet("Tweet10","u5");
		
		ArrayList<Tweet> listeTweets = new ArrayList();
		listeTweets.add(t1);
		listeTweets.add(t2);
		listeTweets.add(t3);
		listeTweets.add(t4);
		listeTweets.add(t5);
		listeTweets.add(t6);
		listeTweets.add(t7);
		listeTweets.add(t8);
		listeTweets.add(t9);
		listeTweets.add(t10);
		
		triListeParDate(listeTweets);
		
		Utilisateur test = new Utilisateur("t", "test", "mdptest");
		test.AjouterAbonnement(u3.getIdUtilisateur());
		test.AjouterAbonnement(u5.getIdUtilisateur());
		System.out.println("test");
		afficheListeTweetsAbo(test, listeTweets);
		System.out.println("test2");
		
		
		
	}
	
	public static ArrayList<Tweet> triListeParDate(ArrayList<Tweet> lt) {
		boolean echange_fait;
		Tweet t1 = new Tweet();
		Tweet t2 = new Tweet();
		do {
			echange_fait = false;
			for (int i=0; i<lt.size()-1; i++) {
				if (lt.get(i).getDateHeureTweet().compareTo(lt.get(i+1).getDateHeureTweet()) > 0) {
					t1 = lt.get(i);
					t2 = lt.get(i+1);
					lt.add(i, t2);
					lt.add(i+1, t1);
					echange_fait = true;
				}
			}
		} while (echange_fait == true);
		return lt;
	}
	
	public static ArrayList<Tweet> getListeTweetsAbo(Utilisateur u, ArrayList<Tweet> lt) {
		ArrayList<Tweet> listeTweets = new ArrayList();
		for (int i=0; i<u.getListeAbonnements().size(); i++) {
			for (int j=0; j<lt.size(); j++) {
				System.out.println(lt.get(j).getIdUtilisateur() + " - " + u.getListeAbonnements().get(i));
				if (lt.get(j).getIdUtilisateur() == u.getListeAbonnements().get(i)) {
					listeTweets.add(lt.get(j));
				}
			}
		}
		return listeTweets;
	}
	
	public static void afficheListeTweetsAbo(Utilisateur u, ArrayList<Tweet> lt) {
		for (int i=0; i<u.getListeAbonnements().size(); i++) {
			for (int j=0; j<lt.size(); j++) {
				if (lt.get(j).getIdUtilisateur() == u.getListeAbonnements().get(i)) {
					System.out.println(lt.get(j).getIdUtilisateur() + " : " + lt.get(j).getMessageTweet());
				}
			}
		}
	}
	
	
}
