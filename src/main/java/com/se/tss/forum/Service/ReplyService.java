package com.se.tss.forum.Service;


import com.se.tss.forum.Entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyService extends JpaRepository<ReplyEntity, String> {
}
