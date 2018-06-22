package com.se.tss.forum.Service;

import com.se.tss.forum.Entity.PostEntity;
import com.se.tss.forum.Entity.SessionEntity;
import com.se.tss.forum.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostService extends JpaRepository<PostEntity, String> {
    PostEntity findByTopic(String topic);
    List<PostEntity> findAllBySessionOrderByCreateTimeDesc(SessionEntity s);
}