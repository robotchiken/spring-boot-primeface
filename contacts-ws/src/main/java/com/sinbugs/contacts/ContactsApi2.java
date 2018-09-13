package com.sinbugs.contacts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsApi2 {
	@RequestMapping(value="/product2", method=RequestMethod.GET)
	public String prueba(){
		return "prueba";
	}
}
