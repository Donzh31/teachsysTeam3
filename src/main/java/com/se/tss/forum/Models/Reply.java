package com.se.tss.forum.Models;

import java.sql.Timestamp;

public class Reply {
    private Integer rid;
    private String content;
    private Timestamp reply_time;
    private Integer post_pid;
    private String post_ptopic;
    private Integer creator_uid;
    private String creator_uname;

    public Reply() {
    }

    public Integer getPost_pid() {
        return post_pid;
    }

    public void setPost_pid(Integer post_pid) {
        this.post_pid = post_pid;
    }

    public String getPost_ptopic() {
        return post_ptopic;
    }

    public void setPost_ptopic(String post_ptopic) {
        this.post_ptopic = post_ptopic;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getReply_time() {
        return reply_time;
    }

    public void setReply_time(Timestamp reply_time) {
        this.reply_time = reply_time;
    }

    public Integer getCreator_uid() {
        return creator_uid;
    }

    public void setCreator_uid(Integer creator_uid) {
        this.creator_uid = creator_uid;
    }

    public String getCreator_uname() {
        return creator_uname;
    }

    public void setCreator_uname(String creator_uname) {
        this.creator_uname = creator_uname;
    }
}

