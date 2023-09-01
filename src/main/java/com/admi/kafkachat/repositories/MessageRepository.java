package com.admi.kafkachat.repositories;

import com.admi.kafkachat.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<ChatMessage, Long> {
}