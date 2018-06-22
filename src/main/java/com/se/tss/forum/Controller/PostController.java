package com.se.tss.forum.Controller;
import com.se.tss.forum.Entity.PostEntity;
import com.se.tss.forum.Entity.SessionEntity;
import com.se.tss.forum.Entity.UserEntity;
import com.se.tss.forum.Models.Post;
import com.se.tss.forum.Service.PostService;
import com.se.tss.forum.Service.ReplyService;
import com.se.tss.forum.Service.SessionService;
import com.se.tss.forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin
@RestController
public class PostController {
    @Autowired
    SessionService sessionService;
    @Autowired
    ReplyService replyService;
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    //创建帖子
    //返回值：帖子序号
    @RequestMapping(value = "bbs/post/create")
    public Post createPost(@RequestBody Post p)
    {
        PostEntity postEntity = new PostEntity();
        postEntity.setSession(sessionService.findBySid(p.getSession_sid()));
        postEntity.setTopic(p.getTopic());
        postEntity.setContent(p.getContent());
        postEntity.setCreator(userService.findByName("user1"));
        postEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        postEntity.setClickCount(0);
        postEntity.setReplyCount(0);
        postEntity.setLastReplier(userService.findByName("user1"));
        postEntity.setLastReplyTime(new Timestamp(System.currentTimeMillis()));
        postService.save(postEntity);
        p.setPid(postEntity.getPid());
        return p;
    }
    //查询某用户帖子
    @RequestMapping(value = "/bbs/post/user/{uid}")
    public List<PostEntity> userPost(@PathVariable String uid){
        UserEntity u = userService.getOne(uid);
        List<PostEntity> postEntities = u.getCreatedPost();
        return postEntities;
    }
    //查询某版块帖子
    @RequestMapping(value = "/bbs/post/session/{sid}")
    public List<Post> sessionPost(@PathVariable String sid){
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        SessionEntity s = sessionService.findBySid(sid);
        List<PostEntity> postEntities = postService.findAllBySessionOrderByCreateTimeDesc(s);// s.getPostEntities();
        List<Post> posts = new ArrayList<>();
        for(PostEntity pe: postEntities)
        {
           Post p = pe.getPost();
           posts.add(p);
        }
        return posts;
    }
    @RequestMapping(value = "/topic/{sid}")
    public List<PostEntity> dispTopic(@PathVariable String sid){
        Optional<SessionEntity> s = sessionService.findById(sid);
        return s.get().getPostEntities();
    }
}