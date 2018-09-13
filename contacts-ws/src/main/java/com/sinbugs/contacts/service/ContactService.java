package com.sinbugs.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinbugs.contacts.dao.ContactRepository;
import com.sinbugs.contacts.dto.Contact;

@Service
public class ContactService {
	@Autowired
	private ContactRepository dao;
	
	public Contact save(Contact contact){
		return dao.save(contact);
	}

	public ContactRepository getDao() {
		return dao;
	}

	public void setDao(ContactRepository dao) {
		this.dao = dao;
	}
	
}
