package com.se.tss.forum.Controller;

import com.se.tss.forum.Entity.NoticeEntity;
import com.se.tss.forum.Models.Notice;
import com.se.tss.forum.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin
@RestController
public class NoticeController {
    @Autowired
    UserService userService;
    @Autowired
    NoticeService noticeService;
    //创建公告
    //返回值：新建公告的序号
    @RequestMapping(value = "bbs/notice/create")
    public Notice createNotice(@RequestBody Notice n)
    {
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setTopic(n.getTopic());
        noticeEntity.setContent(n.getContent());
        noticeEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        noticeEntity.setCreator(userService.findByName("user1"));
        noticeEntity.setModifiedTime(new Timestamp(System.currentTimeMillis()));
        noticeService.save(noticeEntity);
        n.setNid(noticeEntity.getNid());
        return n;
    }
    //查询所有公告
    //返回：所有公告列表
    @RequestMapping(value = "/bbs/notice/all")
    public List<Notice> allNotice(){
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        List<NoticeEntity> noticeEntities = noticeService.findAll(sort);
        List<Notice> notices = new ArrayList<>();
        for(NoticeEntity ne: noticeEntities)
        {
            Notice n = ne.getNotice();
            notices.add(n);
        }
        return notices;
    }
}
