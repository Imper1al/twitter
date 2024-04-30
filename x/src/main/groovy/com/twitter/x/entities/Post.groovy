package com.twitter.x.entities

import groovy.transform.Canonical
import groovy.transform.TupleConstructor
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@TupleConstructor
@Canonical
@Document(collection = "posts")
class Post {

    @Id
    private ObjectId id
    private String content
    private ObjectId userId
    private Date createdAt
    private int likes = 0
    private int comments

    void incrementLikes() {
        this.likes++
    }

    void decrementLikes() {
        if (this.likes > 0) {
            this.likes--
        }
    }

    ObjectId getId() {
        return id
    }

    void setId(ObjectId id) {
        this.id = id
    }

    String getContent() {
        return content
    }

    void setContent(String content) {
        this.content = content
    }

    ObjectId getUserId() {
        return userId
    }

    void setUserId(ObjectId userId) {
        this.userId = userId
    }

    Date getCreatedAt() {
        return createdAt
    }

    void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt
    }

    int getLikes() {
        return likes
    }

    void setLikes(int likes) {
        this.likes = likes
    }

    int getComments() {
        return comments
    }

    void setComments(int comments) {
        this.comments = comments
    }
}
