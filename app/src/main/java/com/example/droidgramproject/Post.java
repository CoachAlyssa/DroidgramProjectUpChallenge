package com.example.droidgramproject;

import android.media.Image;

import java.util.ArrayList;

public class Post {
    String droidName;
    int droidImage;
    int numLikes;
    String description;
    ArrayList<String> comments;

    public Post(String name, int img, String about) {
        droidName = name;
        droidImage = img;
        numLikes = 0;
        description = about;
        comments = new ArrayList<>();
    }

    public String getDroidName() {
        return droidName;
    }

    public void setDroidName(String droidName) {
        this.droidName = droidName;
    }

    public int getDroidImage() {
        return droidImage;
    }

    public void setDroidImage(int droidImage) {
        this.droidImage = droidImage;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

}
