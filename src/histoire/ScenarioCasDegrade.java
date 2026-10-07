package histoire;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;
import villagegaulois.VillageSansChefException;

public class ScenarioCasDegrade {

	public static void main(String[] args) {
		Etal etal = new Etal();
		System.out.println(etal.libererEtal());

		Gaulois bonemine = new Gaulois("Bonemine", 7);
		etal.occuperEtal(bonemine, "fleurs", 20);
		System.out.println(etal.acheterProduit(5, null));

		try {
			System.out.println(etal.acheterProduit(-3, bonemine));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		Etal etalVide = new Etal();
		try {
			System.out.println(etalVide.acheterProduit(5, bonemine));
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}

		Village village = new Village("le village sans chef", 10, 5);
		try {
			System.out.println(village.afficherVillageois());
		} catch (VillageSansChefException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Fin du test");
	}

}
