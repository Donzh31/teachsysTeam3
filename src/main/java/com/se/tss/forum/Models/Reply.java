package com.se.tss.forum.Models;

import java.sql.Timestamp;

public class Reply {
    private Integer rid;
    private String content;
    private Timestamp reply_time;
    private Integer creator_uid;
    private String creator_uname;

    public Reply() {
    }

    public Reply(Integer rid, String content, Timestamp reply_time, Integer creator_uid, String creator_uname) {
        this.rid = rid;
        this.content = content;
        this.reply_time = reply_time;
        this.creator_uid = creator_uid;
        this.creator_uname = creator_uname;
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

