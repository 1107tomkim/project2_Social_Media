package dev.jsonmusk.entities;

import java.util.Arrays;
import java.util.Date;

public class Post {

    // id, userid, postText, postPhoto, date

    private String postText;


    private int postId;
    private int userId;


    private Date date;
    private byte[] postPhoto;

    public Post() {
        this.postText = "";
        this.postId = 0;
        this.userId = 0;
        this.date = null;
        this.postPhoto = null;
    }
    public Post(int userId, int postId, String postText, Date date, byte[] postPhoto) {
        this.postText = postText;
        this.postId = postId;
        this.userId = userId;
        this.date = null;
        this.postPhoto = null;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getPostPhoto() {
        return postPhoto;
    }

    public void setPostPhoto(byte[] postPhoto) {
        this.postPhoto = postPhoto;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postText='" + postText + '\'' +
                ", postId=" + postId +
                ", userId=" + userId +
                ", date=" + date +
                ", postPhoto=" + Arrays.toString(postPhoto) +
                '}';
    }
}
