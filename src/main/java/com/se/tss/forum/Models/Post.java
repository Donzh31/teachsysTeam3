package com.se.tss.forum.Models;
import java.sql.Timestamp;
import java.util.List;

public class Post {
    private Integer pid;
    private String sname;
    private String topic;
    private String content;
    private Integer creatorId;
    private Timestamp createTime;
    private List<Integer> replyId;
    private Integer replyCount;
    private Integer clickCount;
    private Integer lastReplyId;
    private Timestamp lastReplyTime;

    public Post() {
    }

    public Post(Integer pid, String sname, String topic, String content, Integer creatorId) {
        this.pid = pid;
        this.sname = sname;
        this.topic = topic;
        this.content = content;
        this.creatorId = creatorId;
        this.createTime = new Timestamp(System.currentTimeMillis());
        //this.replyId = creatorId;
        this.replyCount = 0;
        this.clickCount = 0;
        //this.lastReplyId = creatorId;
        //this.lastReplyTime
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<Integer> getReplyId() {
        return replyId;
    }

    public void setReplyId(List<Integer> replyId) {
        this.replyId = replyId;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getLastReplyId() {
        return lastReplyId;
    }

    public void setLastReplyId(Integer lastReplyId) {
        this.lastReplyId = lastReplyId;
    }

    public Timestamp getLastReplyTime() {
        return lastReplyTime;
    }

    public void setLastReplyTime(Timestamp lastReplyTime) {
        this.lastReplyTime = lastReplyTime;
    }
}
