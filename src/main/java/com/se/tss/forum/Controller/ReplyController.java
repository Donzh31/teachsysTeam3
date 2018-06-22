package com.se.tss.forum.Controller;

import com.se.tss.forum.Entity.NoticeEntity;
import com.se.tss.forum.Entity.ReplyEntity;
import com.se.tss.forum.Models.Notice;
import com.se.tss.forum.Models.Reply;
import com.se.tss.forum.Service.NoticeService;
import com.se.tss.forum.Service.PostService;
import com.se.tss.forum.Service.ReplyService;
import com.se.tss.forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

//@CrossOrigin
@RestController
public class ReplyController {
    @Autowired
    ReplyService replyService;
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    //创建回帖
    //返回值：回帖的信息+序号
    @RequestMapping(value = "bbs/post/reply")
    public Reply createNotice(@RequestBody Reply r) {
        ReplyEntity replyEntity = new ReplyEntity();
        replyEntity.setCreator(userService.findByName("user1"));//userService.findByUid(r.getCreator_uid()));
        replyEntity.setContent(r.getReply_content());
        replyEntity.setReplyTime(new Timestamp(System.currentTimeMillis()));
        replyEntity.setPost(postService.findByPid(r.getPid()));
        replyService.save(replyEntity);
        r.setRid(replyEntity.getRid());
        return r;
    }

}