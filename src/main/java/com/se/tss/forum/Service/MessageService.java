package com.se.tss.forum.Service;

import com.se.tss.forum.Entity.MessageEntity;
import com.se.tss.forum.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageService extends JpaRepository<MessageEntity, String> {
    List<MessageEntity> findBySenderOrReceiverOrderBySendTime(UserEntity u1, UserEntity u2);
}
