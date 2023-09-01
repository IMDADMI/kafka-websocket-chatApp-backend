package com.admi.kafkachat.websocket;

import com.admi.kafkachat.kafka.MessageProducer;
import com.admi.kafkachat.models.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class WebSocketController {
    private final MessageProducer messageProducer;

    public WebSocketController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }
    @MessageMapping("/chat")
//    @SendTo("/topic/chatMessages")
    public void redirectToProducer(ChatMessage chatMessage){
        log.info("this is the message {}",chatMessage);
        messageProducer.sendMessage(chatMessage);
//        return chatMessage;
    }
}
