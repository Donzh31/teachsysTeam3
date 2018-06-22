package com.se.tss.forum.Controller;
import com.se.tss.forum.Entity.PostEntity;
import com.se.tss.forum.Entity.SessionEntity;
import com.se.tss.forum.Models.Post;
import com.se.tss.forum.Service.PostService;
import com.se.tss.forum.Service.SessionService;
import com.se.tss.forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin
@RestController
public class PostController {
    @Autowired
    SessionService sessionService;
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
    //查询特定帖子详细信息
    @RequestMapping(value = "/bbs/post/find/{pid}")
    public Post specPost(@PathVariable Integer pid){
        PostEntity pe = postService.findByPid(pid);
        Post p = pe.getPost();
        return  p;
    }
    //查询某版块帖子
    @RequestMapping(value = "/bbs/post/session/{sid}")
    public List<Post> sessionPost(@PathVariable String sid){
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
    //查询热门帖子
    @RequestMapping(value = "/bbs/post/hot")
    public List<Post> hotPost(){
        Sort sort = new Sort(Sort.Direction.DESC, "clickCount");
        List<PostEntity> pe = postService.findAll(sort);
        List<Post> posts = new ArrayList<>();
        for(int i = 0; i<10; i++)
        {
            Post p = pe.get(i).getPost();
            posts.add(p);
        }
        return posts;
    }
    //删除帖子
    //帖子ID，删除者ID
    @RequestMapping(value = "/bbs/post/delete/{pid}/{uid}")
    public String deletePost(@PathVariable Integer pid, @PathVariable Integer uid){
        PostEntity pe = postService.findByPid(pid);
        if(uid == pe.getCreator().getUid())
        {
            postService.delete(pe);
            return "Delete succeed";
        }
        return "Delete failed, you don't have authority";
    }
}