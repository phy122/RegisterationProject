package com.example.registerationproject.models;

public class Post {
    private String title;
    private String content;
    private int likes;

    public Post() {
        // Default constructor required for Firestore
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.likes = 0; // 초기 좋아요 수는 0으로 설정
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void increaseLikes() {
        likes++;
    }
}


