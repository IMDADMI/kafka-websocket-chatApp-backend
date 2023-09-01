package com.admi.kafkachat.kafka;

import com.admi.kafkachat.models.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProducer {
    private KafkaTemplate<String, ChatMessage> stringKafkaTemplate;

    public MessageProducer(KafkaTemplate<String, ChatMessage> stringKafkaTemplate) {
        this.stringKafkaTemplate = stringKafkaTemplate;
    }
    public void sendMessage(ChatMessage chatMessage){

        Message<ChatMessage> userModelChatMessage = MessageBuilder.withPayload(chatMessage).setHeader(KafkaHeaders.TOPIC,Helper.TOPIC).build();
        stringKafkaTemplate.send(userModelChatMessage);
        log.info("the message is sent : {}",chatMessage);

    }


}
