package org.generation.italy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.generation.italy.model.entity.Movimento;

public class MovimentoDao extends Dao {

	public MovimentoDao(Connection jdbcConnectionToDatabase) {
		super(jdbcConnectionToDatabase);

	}

   public List<Movimento> loadMovimentoByImportoOverAndPrelievo (int importo) throws SQLException{	//metodo select che in java sarebbe load
	   String selectFromMovimentoByImportoOverAndPrelievo =
	   		" SELECT iban,importo,tipo_operazione "
          + " FROM movimento"
          + " WHERE tipo_operazione = 'P' "
          + " AND importo > ? ";

       PreparedStatement preparedStatement = jdbcConnectionToDatabase.prepareStatement(selectFromMovimentoByImportoOverAndPrelievo);							                     	

       preparedStatement.setInt(1, importo );				                 


       ResultSet rsSelect = preparedStatement.executeQuery();

       	List<Movimento> elencoMovimenti = new ArrayList<>();									                  

	    while (rsSelect.next()) {												 			

	        String iban = rsSelect.getString("iban");				
	        if (rsSelect.wasNull()) {
	           iban = "";
	        }


	        int importo2 = rsSelect.getInt("importo");	
	        if (rsSelect.wasNull()) {
	        	importo2 = 0;
	        }
	        
	        String tipoOperazione = rsSelect.getString("tipo_operazione");				
	        if (rsSelect.wasNull()) {
	           tipoOperazione = "";
	        }



	        Movimento movimento = new Movimento (iban, importo2, tipoOperazione);	//istanzia un oggetto di tipo classe Cliente inizializzandolo con i valori letti dal record
	        elencoMovimenti.add(movimento);


	    }            


	return elencoMovimenti;
   }



}