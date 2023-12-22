package org.generation.italy.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.generation.italy.model.dao.MovimentoDao;
import org.generation.italy.model.entity.Movimento;

public class JdbcCrudBancaMain {

	public static void main(String[] args) throws SQLException{


		        // Connessione al database
				String databaseName = "banca";										//nome del database a cui connettersi
				String dbmsUserName = "root";											//nome utente configurato nel dbms
				String dbmsPassword = "";												//password utente configurato nel dbms
				String jdbcUrl = "jdbc:mariadb://localhost:3306/" + databaseName;		

				try {																	//prova ad eseguire le istruzioni interne al blocco try-catch

					/****************************************************************************/
					/*					CONNESSIONE AL DATABASE									*/
					/****************************************************************************/
					Connection jdbcConnectionToDatabase = 								//esegue la connessione al dbms con riferimento al database, se fallisce genera eccezzione SQLException (effettuare il debugging per verificarlo)
							DriverManager.getConnection(jdbcUrl
													  , dbmsUserName
													  , dbmsPassword);

					System.out.println("Connessione al database magazzino riuscita!");

					MovimentoDao movimentoDao = new MovimentoDao(jdbcConnectionToDatabase);

					List<Movimento> elencoMovimenti = new ArrayList<>();
                     elencoMovimenti = movimentoDao.loadMovimentoByImportoOverAndPrelievo(255);

 
                  
					if (elencoMovimenti.size()>0)
						
						System.out.println("i dati del movimento trovato sono:\n " + elencoMovimenti.toString());
                     
					else
						System.out.println("I dati non esistono");
                     

				} catch (SQLException e) {												//errore di tipo classe SQLException

					e.printStackTrace();												//stampa la pila (stack) degli errori, dal pi  recente al meno recente
				}

	}


}