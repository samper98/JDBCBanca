package org.generation.italy.model.entity;

public class Conto {

	String valuta, codiceFiscale, iban;
	float scoperto;
	//int dataOraIntestazione;

	public Conto(String valuta, String codiceFiscale, String iban, float scoperto) {
		super();
		this.valuta = valuta;
		this.codiceFiscale = codiceFiscale;
		this.iban = iban;
		this.scoperto = scoperto;
	}

}