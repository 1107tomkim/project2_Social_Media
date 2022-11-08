package dev.jsonmusk.entities;

import java.util.Arrays;
import java.util.Date;

public class Post {

    // id, userid, caption, image, date

    private String caption;


    private int id;
    private int userId;


    private Date date;
    private byte[] image;

    public Post() {
        this.caption = "";
        this.id = 0;
        this. userId = 0;
        this.date = null;
        this.image = null;
    }
    public Post(int userId, int id, String caption, Date date, byte[] image) {
        this.caption = caption;
        this.id = id;
        this.userId = userId;
        this.date = null;
        this.image = null;
    }


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
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

    @Override
    public String toString() {
        return "Post{" +
                "caption='" + caption + '\'' +
                ", id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", image(size)=" + image.length +
                '}';
    }



}
