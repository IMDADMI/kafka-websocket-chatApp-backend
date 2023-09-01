package com.admi.kafkachat.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.LoggerFactory;


@Entity
@Data
@NoArgsConstructor
@ToString
public class ChatMessage {
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long messageId;
    @Column(name = "from_contact")
    private String fromContact;
    @Column(name = "message_content")
    private String messageContent;

    @Column(name = "send_time")
    private Long sendTime;

//    @Column(name = "contact_id")
//    @ManyToOne
//    @JoinColumn(name = "contactId")
//    private Contact contact_id;
    @Column(name = "to_contact")
    private String toContact;

    @PostPersist
    public void postPersist() {
        LoggerFactory.getLogger(this.getClass()).info("a message is persisted");
    }

}
