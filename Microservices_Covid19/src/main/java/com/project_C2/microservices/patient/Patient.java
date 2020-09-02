package com.project_C2.microservices.patient;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Persistent patient entity with JPA markup.
 *  Patients are stored in an H2
 * relational database.
 * 
 * @author Michel IBRAHIM
 */

@Entity
@Table(name = "table_name")

public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;
	
	@Id
	protected Long id;
	
	/**
	 * 
	 * @return The next available id.
	 */
	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}
	}	
	
	public long getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. 
	 * Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setId(long id) {
		this.id = id;
	}	
	
	/**
	 * 
	 * we should continue when table patient is done on h2
	 */
	
	
}
