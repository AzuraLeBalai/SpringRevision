package fr.butinfo.flight;

public class Main {
	public static void main(String[] args) {
		CarteEmbarquement carte = new CarteEmbarquement(
			"MATHIEU", "AF443", "A52", "10:35"
		);

		System.out.println(carte);
		System.out.println(carte.numeroVol());
		
		ServiceEnregistrement serviceEnregistrement = new ServiceEnregistrement();
		String json = serviceEnregistrement.encodeCarte(carte);
		System.out.println( json );

		String empreinte = serviceEnregistrement.calculerEmpreinte(json);		
		System.out.println( empreinte );
		
		System.out.println(serviceEnregistrement.lireEtVerifier(json, empreinte));
	}
}
