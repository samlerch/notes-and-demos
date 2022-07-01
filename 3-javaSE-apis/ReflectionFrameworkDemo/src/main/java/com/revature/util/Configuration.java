package com.revature.util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * The purpose of this class is to have the User only provide a few things in order for the ORM to establish
 * a connection and build the tables based on a list of USer-defined classes that the user passes to the ORM to
 * introspect and construct in the DB
 */
public class Configuration {

	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	
	// We should include the list of classes that user wants our ORM to "scan" aka instrospect and build
	private List<MetaModel<Class<?>>> metaModelList;
	
	// Let's create a method to add in out annotated classes
	// This is similar to the mapping of the hibernate.cfg.xml
	
	public Configuration addAnnotatedClass(Class annotatedClass) {
		
		// First let's check if the metamodel list has been instantiated
		// if not, let's instantiate it
		// This is similar to a singleton get connection where you either have a list already or create one
		
		if (metaModelList == null) {
			metaModelList = new LinkedList<>();
		}
		
		// We need to call the method that transforms a class into an appropriate data model that our 
		// ORM can instrospect (a metamodel)
		metaModelList.add(MetaModel.of(annotatedClass));
		
		return this; // Let's return this configuration object on which the annotated class now exists in the metamodel list
	}
	
	public List<MetaModel<Class<?>>> getMetaModels(){
		
		//In the case the metamodel list is empty we should return just an empty list
		// otherwise just return the metamodel
		
		return (metaModelList == null) ? Collections.emptyList() : metaModelList;
	}
	
	//One final method that might want
	
	public Connection getConnection(String dbUrl, String dbUsername, String dbPassword) {
		
		this.dbUrl = dbUrl;
		this.dbUsername= dbUsername;
		this.dbPassword = dbPassword;
		
		// This is where things can get creative
		
		// You may want to create a connection here....up to you for proj 1!
		
		// Now you can access the configs variable for connection since we just set the instance variables
		// SO you might want set up your connection and then start building tables, etc...
		
		// for right now since we're omitting the logic we'll just return null;
		return null;
	}
}
