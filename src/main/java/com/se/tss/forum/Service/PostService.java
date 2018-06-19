package com.se.tss.forum.Service;

import com.se.tss.forum.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostService extends JpaRepository<PostEntity, String> {
    PostEntity findByTopic(String topic);
}