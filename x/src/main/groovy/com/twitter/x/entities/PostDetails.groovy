package com.twitter.x.entities

import groovy.transform.Canonical
import groovy.transform.TupleConstructor

@TupleConstructor
@Canonical
class PostDetails {

    private Post post
    private List<Comment> comments
    private int likesCount

    PostDetails(Post post, List<Comment> comments, int likesCount) {
        this.post = post
        this.comments = comments
        this.likesCount = likesCount
    }

    Post getPost() {
        return post
    }

    void setPost(Post post) {
        this.post = post
    }

    List<Comment> getComments() {
        return comments
    }

    void setComments(List<Comment> comments) {
        this.comments = comments
    }

    int getLikesCount() {
        return likesCount
    }

    void setLikesCount(int likesCount) {
        this.likesCount = likesCount
    }
}
