package projet.tiers1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

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
		
		Tweet t1 = new Tweet("Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam et velit id mi fringilla rhoncus eget porta diam. Vivamus accumsan, metus nec dictum accumsan, tortor orci lobortis elit, sit amet hendrerit mauris risus in augue. Mauris ultricies faucibus justo eget feugiat. Praesent nec rhoncus odio. Pellentesque tempus cursus mauris. Ut nec dictum metus.","u1");
		Tweet t2 = new Tweet("Le sil6 c'est trop cool!","u1");
		Tweet t3 = new Tweet("Tweet3","u5");
		Tweet t4 = new Tweet("Phasellus tempor quam a vulputate ultricies. Donec non massa ullamcorper, pharetra leo ultrices, suscipit leo. Proin magna magna, cursus ac mauris sed, ornare tincidunt urna. Donec tincidunt lacus posuere nulla.","u3");
		Tweet t5 = new Tweet("Suivez utilisateur3 pour tous les potins!","u3");
		Tweet t6 = new Tweet("Tweet6","u4");
		Tweet t7 = new Tweet("Donec varius nunc volutpat.","u2");
		Tweet t8 = new Tweet("Tweet8","u5");
		Tweet t9 = new Tweet("Java EE 7 requires JDK 7 as it make use of some of the latest Java SE 7 features (e.g. JMS 2 uses Java 7 auto-closeable interfaces).","u4");
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
		
		Utilisateur test1 = new Utilisateur("t1", "test", "mdp1");
		Utilisateur test2 = new Utilisateur("t2", "test", "mdp2");
		Utilisateur test3 = new Utilisateur("t3", "test", "mdp3");
		Utilisateur test4 = new Utilisateur("t4", "test", "mdp4");
		Utilisateur test5 = new Utilisateur("t5", "test", "mdp5");
		test1.AjouterAbonnement(u3.getIdUtilisateur());
		test1.AjouterAbonnement(u5.getIdUtilisateur());
		test2.AjouterAbonnement(u1.getIdUtilisateur());
		test2.AjouterAbonnement(u4.getIdUtilisateur());
		test2.AjouterAbonnement(u3.getIdUtilisateur());
		test3.AjouterAbonnement(u4.getIdUtilisateur());
		test4.AjouterAbonnement(u3.getIdUtilisateur());
		test4.AjouterAbonnement(u5.getIdUtilisateur());
		test4.AjouterAbonnement(u1.getIdUtilisateur());
		test4.AjouterAbonnement(u2.getIdUtilisateur());
		test5.AjouterAbonnement(u1.getIdUtilisateur());
		test5.AjouterAbonnement(u2.getIdUtilisateur());
		test5.AjouterAbonnement(u3.getIdUtilisateur());
		
		ArrayList<Utilisateur> listeUtilisateurs = new ArrayList();
		listeUtilisateurs.add(test1);
		listeUtilisateurs.add(test2);
		listeUtilisateurs.add(test3);
		listeUtilisateurs.add(test4);
		listeUtilisateurs.add(test5);
		
		Utilisateur user = new Utilisateur();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~ Bienvenue sur Pwitter ~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		user = connexion(listeUtilisateurs);
		
		afficheListeTweetsAbo(user, listeTweets);
		
	}
	
	public static Utilisateur connexion(ArrayList<Utilisateur> listeUtilisateurs) {
		System.out.println("-- Connexion --");
		Utilisateur connected_user = new Utilisateur();
		boolean id_ok = false;
		String id = new String();
		Scanner sc = new Scanner(System.in);
		while (!id_ok) {
			System.out.println("Entrez votre identifiant pwitter : ");
			id = sc.next();
			int i=0;
			while (i<listeUtilisateurs.size() && !id_ok) {
				if (listeUtilisateurs.get(i).getIdUtilisateur().equals(id)) {
					id_ok = true;
					connected_user = listeUtilisateurs.get(i);
				}
				i++;
			}
		}
		
		boolean pass_ok = false;
		String pass = new String();
		while (!pass_ok) {
			System.out.println("Entrez votre mot de passe pwitter : ");
			pass = sc.next();
			int i=0;
			if (pass.equals(connected_user.getMDPUtilisateur())) {
					pass_ok = true;
			}
		}
		return connected_user;
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
		System.out.println("-- Vos tweets --");
		for (int i=0; i<u.getListeAbonnements().size(); i++) {
			for (int j=0; j<lt.size(); j++) {
				if (lt.get(j).getIdUtilisateur() == u.getListeAbonnements().get(i)) {
					System.out.println("..................");
					System.out.println("Author : " + lt.get(j).getIdUtilisateur());
					System.out.println("\"" + lt.get(j).getMessageTweet() + "\"");
					System.out.println("(" + lt.get(j).getDateHeureTweet() + ")");
					System.out.println();
				}
			}
		}
	}
	
	
}
