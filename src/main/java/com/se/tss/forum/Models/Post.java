package com.se.tss.forum.Models;
import java.sql.Timestamp;
import java.util.List;

public class Post {
    private Integer pid;
    private String topic;
    private String content;
    private String session_sid;
    private String session_sname;
    private Integer creator_uid;
    private String creator_uname;
    private Timestamp create_time;
    private Integer reply_count;
    private Integer click_count;
    private List<Reply> replys;

    public Post() {
    }

    public Post(Integer pid, String topic, String content, String session_sid, String session_sname, Integer creator_uid, String creator_uname, Timestamp create_time, Integer reply_count, Integer click_count, List<Reply> replys) {
        this.pid = pid;
        this.topic = topic;
        this.content = content;
        this.session_sid = session_sid;
        this.session_sname = session_sname;
        this.creator_uid = creator_uid;
        this.creator_uname = creator_uname;
        this.create_time = create_time;
        this.reply_count = reply_count;
        this.click_count = click_count;
        this.replys = replys;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSession_sid() {
        return session_sid;
    }

    public void setSession_sid(String session_sid) {
        this.session_sid = session_sid;
    }

    public String getSession_sname() {
        return session_sname;
    }

    public void setSession_sname(String session_sname) {
        this.session_sname = session_sname;
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

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Integer getReply_count() {
        return reply_count;
    }

    public void setReply_count(Integer reply_count) {
        this.reply_count = reply_count;
    }

    public Integer getClick_count() {
        return click_count;
    }

    public void setClick_count(Integer click_count) {
        this.click_count = click_count;
    }

    public List<Reply> getReplys() {
        return replys;
    }

    public void setReplys(List<Reply> replys) {
        this.replys = replys;
    }
}
