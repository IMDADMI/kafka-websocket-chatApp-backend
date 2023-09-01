package com.admi.kafkachat.controllers;

import com.admi.kafkachat.kafka.MessageProducer;
import com.admi.kafkachat.models.Contact;
import com.admi.kafkachat.models.ChatMessage;
import com.admi.kafkachat.repositories.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private ContactRepository contactRepository;
    private MessageProducer messageProducer;


    public ContactController(ContactRepository contactRepository, MessageProducer messageProducer) {
        this.contactRepository = contactRepository;
        this.messageProducer = messageProducer;
    }

    @GetMapping
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable String id){
        return contactRepository.findContactByContactId(Long.parseLong(id)).orElseThrow();
    }
    @PostMapping
    public Contact saveContact(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable String id){
        Long contactId = Long.parseLong(id);
        contactRepository.deleteById(contactId);
    }

    @PostMapping("/test")
    public void sendMessage(@RequestBody ChatMessage chatMessage){
        System.out.println("the message is : "+chatMessage);
        messageProducer.sendMessage(chatMessage);
    }

}
