package com.redhat.services.ui;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.SystemException;

import com.redhat.services.service.PersonService;

@RequestScoped
@Named("person")
public class PersonUI {
	private String name;
	
	@Inject
	private PersonService personService;
	
	public void sayHello() throws IllegalStateException, SecurityException, SystemException {
		String response = personService.hello(name);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(response));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
