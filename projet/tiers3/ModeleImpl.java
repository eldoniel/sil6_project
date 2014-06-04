package projet.tiers3;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ListeInscrits")
@XmlAccessorType(XmlAccessType.FIELD)
public class ModeleImpl implements Modele {

	private static final long serialVersionUID = 1L;
	
	@XmlElementWrapper(name="ListeInscrits")
	@XmlElements({
	@XmlElement(name="Utilisateur")})
	private ArrayList<Utilisateur> ListeInscrits;

	protected ModeleImpl() throws Exception {
		super();
		ListeInscrits = new ArrayList<Utilisateur>();
		this.LoadFromXml();
	}

	// Methodes
	public ArrayList<Utilisateur> getListeInscrits()  throws RemoteException{
		return ListeInscrits;
	}

	public void AjouterUtilisateur(Utilisateur UtilAjout) throws Exception{
		if(!this.ListeInscrits.contains(UtilAjout)){
			this.ListeInscrits.add(UtilAjout);
			this.SaveToXml();
		}
	}
	
	public Utilisateur ModifierUtilisateur(Utilisateur UtilModif, String nom, String mdp) throws Exception{
		int indiceUtil;
		int indiceTweet;
		
		for (indiceUtil = 0; indiceUtil < ListeInscrits.size(); indiceUtil++) {
			if((ListeInscrits.get(indiceUtil).getNomUtilisateur().equals(UtilModif.getNomUtilisateur())
					&& (ListeInscrits.get(indiceUtil).getMDPUtilisateur().equals(UtilModif.getMDPUtilisateur())))){
				ListeInscrits.get(indiceUtil).setNomUtilisateur(nom);
				ListeInscrits.get(indiceUtil).setMDPUtilisateur(mdp);
				this.SaveToXml();
				break;
			}
		}
		
		if (indiceUtil != ListeInscrits.size()){
			return ListeInscrits.get(indiceUtil);
		}
		else{
			return UtilModif;
		}
	}

	public void SupprimerUtilisateur(Utilisateur UtilSupp) throws Exception{
		int indice;
		
		for (indice = 0; indice < ListeInscrits.size(); indice++) {
			if((ListeInscrits.get(indice).getNomUtilisateur().equals(UtilSupp.getNomUtilisateur())
					&& (ListeInscrits.get(indice).getMDPUtilisateur().equals(UtilSupp.getMDPUtilisateur())))){
				this.ListeInscrits.remove(indice);
				this.SaveToXml();
				break;
			}
		}
	}
	
	public void SaveToXml() throws Exception{
		JAXBContext context = JAXBContext.newInstance(ModeleImpl.class) ;
		// création d'un marshaller à partir de ce contexte
		Marshaller marshaller = context.createMarshaller() ;
		// on choisit UTF-8 pour encoder ce fichier
		marshaller.setProperty("jaxb.encoding", "UTF-8") ;
		// et l'on demande à JAXB de formatter ce fichier de façon à pouvoir le lire à l'oeil nu
		marshaller.setProperty("jaxb.formatted.output", true) ;
		marshaller.marshal(this, new File("Twitter.xml"));
	}

	public void LoadFromXml() throws Exception {
		JAXBContext context2 = JAXBContext.newInstance(ModeleImpl.class) ;
		// création d'un unmarshaller
		Unmarshaller unmarshaller = context2.createUnmarshaller() ;
		ModeleImpl ModeleTemp = new ModeleImpl();
		ModeleTemp = (ModeleImpl)unmarshaller.unmarshal(new File("Twitter.xml")) ;
		this.ListeInscrits = ModeleTemp.getListeInscrits();
	}
}
