package projet.tiers3;

public class ServeurModele {

  public static void main(String [] args) throws Exception
	{
		ModeleImpl modele = new ModeleImpl();
		//A ajouter si l’implantation n’hérite pas de UnicastRemoteObjet (méthode 2)
		Modele stub;
		stub = (Modele) UnicastRemoteObject.exportObject(modele,0);
		Registry registry = LocateRegistry.createRegistry(3000);
		registry.bind("ModeleService", stub);
	}


}
