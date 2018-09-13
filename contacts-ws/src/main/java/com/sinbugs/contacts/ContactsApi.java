package com.sinbugs.contacts;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinbugs.contacts.dto.Contact;
import com.sinbugs.contacts.dto.ContactRequest;
import com.sinbugs.contacts.dto.ContactResponse;
import com.sinbugs.contacts.service.ContactService;
@RestController

public class ContactsApi {
	@Autowired
	private ContactService service;
	
	@Autowired
	Mapper mapper;
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public Contact getById(){
        return new Contact("John", "Doe", "+57 311 222 3344", "john@sinbugs.com");
    }
	
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public ContactResponse updateOrSave(@RequestBody @Valid ContactRequest contactRequest){
		Contact contact = mapper.map(contactRequest, Contact.class);
		Contact update  =service.save(contact); 
		ContactResponse contactResponse = mapper.map(update, ContactResponse.class);
		return contactResponse;
	}
	public ContactService getService() {
		return service;
	}

	public void setService(ContactService service) {
		this.service = service;
	}
}
