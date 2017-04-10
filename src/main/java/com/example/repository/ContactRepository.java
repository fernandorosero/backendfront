package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Contact;

@Repository("contactRepository")
public interface ContactRepository  extends JpaRepository<Contact, Serializable>{

	public abstract Contact findById(int id);
	
}
