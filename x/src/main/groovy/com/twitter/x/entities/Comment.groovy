package com.twitter.x.entities

import groovy.transform.Canonical
import groovy.transform.TupleConstructor
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@TupleConstructor
@Canonical
@Document(collection = "comments")
class Comment {

    @Id
    private ObjectId id
    private String content
    private ObjectId postId
    private ObjectId userId
    private Date createdAt

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

    ObjectId getPostId() {
        return postId
    }

    void setPostId(ObjectId postId) {
        this.postId = postId
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
}
