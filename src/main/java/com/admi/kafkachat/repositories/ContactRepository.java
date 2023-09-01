package com.admi.kafkachat.repositories;

import com.admi.kafkachat.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findContactByContactId(Long contactId);

}