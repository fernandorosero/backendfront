package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.component.ContactConverter;
import com.example.entity.Contact;
import com.example.model.ContactModel;
import com.example.repository.ContactRepository;
import com.example.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact  contact = contactRepository.save(contactConverter.converterContactModel2Contact(contactModel));
		return contactConverter.converterContact2ContacModel(contact);
	}

	//@PreAuthorize("permitAll()")
	@Override
	public List<ContactModel> listAllCotnacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for (Contact contact : contacts){
			contactsModel.add(contactConverter.converterContact2ContacModel(contact));
		}
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	public ContactModel findContactByIdByModel(int id){
		return contactConverter.converterContact2ContacModel(findContactById(id));
	}
	
	
	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if(null != contact){
			contactRepository.delete(contact);
		}
}

	
	
}
