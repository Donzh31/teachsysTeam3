package com.se.tss.forum.Service;

import com.se.tss.forum.Entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageService extends JpaRepository<MessageEntity, String> {
}