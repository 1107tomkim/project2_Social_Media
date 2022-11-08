package dev.jsonmusk.entities;

import java.util.Date;

public class Comment {
    private int id;
    private int userId;
    private String text;
    private Date date;
    private int parentId;

    public Comment() {
        this.id = 0;
        this.userId = 0;
        this.text = "";
        this.date = null;
        this.parentId = 0;
    }

    public Comment(int id, int userId, String text, Date date, int parentId) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.date = date;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", parentId=" + parentId +
                '}';
    }
}
