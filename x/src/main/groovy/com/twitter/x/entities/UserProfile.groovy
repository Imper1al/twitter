package com.twitter.x.entities

import groovy.transform.Canonical
import groovy.transform.TupleConstructor

@TupleConstructor
@Canonical
class UserProfile {

    private User user
    private List<PostDetails> posts

    UserProfile(User user, List<PostDetails> posts) {
        this.user = user
        this.posts = posts
    }

    User getUser() {
        return user
    }

    void setUser(User user) {
        this.user = user
    }

    List<PostDetails> getPosts() {
        return posts
    }

    void setPosts(List<PostDetails> posts) {
        this.posts = posts
    }
}
