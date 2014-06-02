package projet.tiers2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import projet.tiers3.Modele;

public class application {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("127.0.0.1",3000);
		Modele modele;
		modele = (Modele) registry.lookup("WeatherService");
	}

}
