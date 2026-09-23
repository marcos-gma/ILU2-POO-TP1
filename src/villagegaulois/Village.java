package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	public class Marche {
		private Etal[] etals;
		private int nbEtals;
		
		public Marche(int nombreEtals) {
			this.nbEtals = nombreEtals;
			for(int i=0; i < nombreEtals; i++) {
				this.etals[i] = new Etal();
			}
		}
		
		public void utiliserEtal(int indiceEtal, Gaulois vendeur,String produit, int nbProduit) {
			this.etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}
		
		public int trouverEtalLibre(){
			for(int i=0; i < this.nbEtals; i++) {
				if (this.etals[i].isEtalOccupe() == false) {
					return i;
				}
			}
			return -1;
		}
		
		public Etal[] trouverEtals(String produit) {
			int nbEtalsVend = 0;
			for(int i=0; i < this.nbEtals; i++) {
				if (this.etals[i].contientProduit(produit) == true) {
					nbEtalsVend++;
				}
			}
			
			Etal[] etalsVend = new Etal[nbEtalsVend];
			
			int j = 0;
			
			for(int i=0; i < this.nbEtals; i++) {
				if (this.etals[i].contientProduit(produit) == true) {
					etalsVend[j] = this.etals[i];
					j++;
				}
			}
			
			return etalsVend;

		}
		
		public Etal trouverVendeur(Gaulois gaulois) {
			
			for(int i=0; i < this.nbEtals; i++) {
				if (this.etals[i].getVendeur() == gaulois) {
					return this.etals[i];
				}
			}

			return null;
		}
		
		public String afficherMarche() {
			
			String etat;
			int nbLibre = 0;
			for(int i=0; i < this.nbEtals; i++) {
				
			}
		}
	}
}