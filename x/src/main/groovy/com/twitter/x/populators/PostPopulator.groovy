package com.twitter.x.populators

import com.twitter.x.entities.Post
import org.springframework.stereotype.Component

@Component
class PostPopulator {

    PostPopulator() {}

    Post populatePost(Post post, Post existingPost) {

        existingPost.setContent(post.getContent())
        existingPost.setComments(post.getComments())
        existingPost.setCreatedAt(post.getCreatedAt())
        existingPost.setLikes(post.getLikes())

        return existingPost
    }
}
