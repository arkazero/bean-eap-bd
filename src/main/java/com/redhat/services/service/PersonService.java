package com.redhat.services.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.redhat.services.model.Person;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class PersonService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Resource
	UserTransaction tx;
	
	public String hello (String name) throws IllegalStateException, SecurityException, SystemException {
		try {
			tx.begin();
			
			LocalDateTime today = LocalDateTime.now();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMM dd yyyy hh:mm:ss a");
			String fdate = today.format(format);
			
			Person p = new Person();
			p.setName(name);
			entityManager.persist(p);
			
			tx.commit();
			
			return "Hello "+ name.toUpperCase() + "!. "+ "Time on the server is: "+ fdate;
		} catch (Exception e) {
			tx.rollback();
			throw new EJBException(e);
		}
		
	}

}
