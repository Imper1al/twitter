package com.twitter.x.services

import com.twitter.x.entities.Post
import org.bson.types.ObjectId

interface PostService {

    List<Post> getAllPosts()
    Post getPostById(ObjectId id)
    Post createPost(Post post)
    void updatePost(Post post)
    void deletePost(ObjectId id)
    List<Post> getPostsByUserId(ObjectId userId)
    int getLikesCountByPostId(ObjectId postId)
    void likePost(ObjectId postId)
    void unlikePost(ObjectId postId)
}