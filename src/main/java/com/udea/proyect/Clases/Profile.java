package com.udea.proyect.Clases;

import java.util.Date;


public class Profile {
    private String id, image, phone;
    private Date createdAt, updatedAt;

    public Profile(String id, String image, String phone, Date createdAt, Date updatedAt) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    } 

    public String toString() {
        return ("id=" + id + ", image=" + image + ", phone=" + phone + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ")");
}
}
