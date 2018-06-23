package com.se.tss.forum.Controller;

import com.se.tss.forum.Entity.MessageEntity;
import com.se.tss.forum.Models.Message;
import com.se.tss.forum.Service.MessageService;
import com.se.tss.forum.Service.PostService;
import com.se.tss.forum.Service.ReplyService;
import com.se.tss.forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin
@RestController
public class MessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    //创建私信
    //传入：sender_id receiver_id message
    @RequestMapping(value = "bbs/message/create")
    public Message createNotice(@RequestBody Message m) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setSender(userService.findByUid(m.getSender_id()));
        messageEntity.setReceiver(userService.findByUid(m.getReceiver_id()));
        messageEntity.setMessage(m.getMessage());
        messageEntity.setSendTime(new Timestamp(System.currentTimeMillis()));
        messageService.save(messageEntity);
        m.setMid(messageEntity.getMid());
        return m;
    }
    //得到某用户相关私信
    @RequestMapping(value = "/bbs/message/all/{uid}")
    public List<Message> searchPost(@PathVariable Integer uid){
        List<MessageEntity> messageEntities = messageService.findBySenderOrReceiverOrderBySendTimeDesc(userService.findByUid(uid),userService.findByUid(uid));
        List<Message> messages = new ArrayList<>();
        for(MessageEntity me: messageEntities)
        {
            Message m = me.getMessageInfo();
            messages.add(m);
        }
        return messages;
    }

}