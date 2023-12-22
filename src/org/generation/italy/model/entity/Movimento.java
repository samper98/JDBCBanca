package org.generation.italy.model.entity;

public class Movimento {

	int idMovimento, importo;
	String tipoOperazione, iban;
	
	//int dataOperazione;


	public Movimento( String iban,int importo , String tipoOperazione) {
		super();
		this.importo = importo;
		this.iban = iban;
		this.tipoOperazione=tipoOperazione;

	}

	public Movimento(int idMovimento, int importo, String tipoOperazione, String iban) {
		super();
		this.idMovimento = idMovimento;
		this.importo = importo;
		this.tipoOperazione = tipoOperazione;
		this.iban = iban;
	}

	@Override
	public String toString() {
		
		return "Movimento [iban= " + iban + " \timporto= " + importo  + " \ttipo operazione= " + tipoOperazione + " ]" +"\n";
	}



}