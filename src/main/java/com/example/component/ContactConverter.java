package com.example.component;

import org.springframework.stereotype.Component;

import com.example.entity.Contact;
import com.example.model.ContactModel;


// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component("contactConverter")
public class ContactConverter {

	/**
	 * Converter contact model 2 contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact
	 */
	public Contact converterContactModel2Contact(ContactModel contactModel){
		Contact contact = new Contact();
		contact.setId(contactModel.getId());
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setCity(contactModel.getCity());
		contact.setTelephone(contactModel.getTelephone());
		return contact;
	}
	
	
	/**
	 * Converter contact 2 contac model.
	 *
	 * @param contact the contact
	 * @return the contact model
	 */
	public ContactModel converterContact2ContacModel(Contact contact){
		ContactModel contactModel = new ContactModel();
		contactModel.setId(contact.getId());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setCity(contact.getCity());
		contactModel.setTelephone(contact.getTelephone());
		return contactModel;
	}
}
