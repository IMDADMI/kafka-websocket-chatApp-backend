package com.admi.kafkachat.kafka;

import com.admi.kafkachat.models.ChatMessage;
import com.admi.kafkachat.repositories.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumer {
    private final MessageRepository messageRepository;
    private final SimpMessageSendingOperations simpMessageSendingOperations;


    public MessageConsumer(MessageRepository messageRepository, SimpMessageSendingOperations simpMessageSendingOperations) {
        this.messageRepository = messageRepository;
        this.simpMessageSendingOperations = simpMessageSendingOperations;
    }

    @KafkaListener(groupId = "spring.kafka.consumer.group-id",topics = Helper.TOPIC)
    public void messageConsumer(ChatMessage chatMessage){
        log.info("consuming the message : {}", chatMessage);
        messageRepository.save(chatMessage);
        simpMessageSendingOperations.convertAndSend("/topic/chatMessages",chatMessage);
        log.info("message sent through websocket");
    }

}
