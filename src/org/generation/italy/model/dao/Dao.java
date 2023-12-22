package org.generation.italy.model.dao;

import java.sql.Connection;

public abstract class Dao { //madre

	Connection jdbcConnectionToDatabase;

	public Dao(Connection jdbcConnectionToDatabase) {
		super();
		this.jdbcConnectionToDatabase = jdbcConnectionToDatabase;

	}


}