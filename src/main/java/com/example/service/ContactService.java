package com.example.service;

import java.util.List;

import com.example.entity.Contact;
import com.example.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllCotnacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactByIdByModel(int id);
}
