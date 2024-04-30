package com.twitter.x.services.impl

import com.twitter.x.entities.Post
import com.twitter.x.exceptions.PostNotFoundException
import com.twitter.x.populators.PostPopulator
import com.twitter.x.repositories.PostRepository
import com.twitter.x.services.PostService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostServiceImpl implements PostService {

    @Autowired
    private final PostRepository postRepository
    @Autowired
    private final PostPopulator postPopulator

    @Override
    List<Post> getAllPosts() {
        postRepository.findAll()
    }

    @Override
    Post getPostById(ObjectId id) {
        postRepository.findById(id).orElse(null)
    }

    @Override
    Post createPost(Post post) {
        post.setCreatedAt(new Date())t
        postRepository.save(post)
    }

    @Override
    void updatePost(Post post) {
        ObjectId postId = post.getId()
        Optional<Post> existingPostOptional = postRepository.findById(postId)
        if (existingPostOptional.isPresent()) {
            Post existingPost = postPopulator.populatePost(post, existingPostOptional.get())
            postRepository.save(existingPost)
        } else {
            throw new IllegalArgumentException("Post not found with ID: " + postId)
        }
    }

    @Override
    List<Post> getPostsByUserId(ObjectId userId) {
        List<Post> posts = postRepository.findByUserId(userId)
        return posts;
    }

    @Override
    void deletePost(ObjectId id) {
        postRepository.deleteById(id)
    }

    @Override
    int getLikesCountByPostId(ObjectId postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found"))
        return post.getLikes()
    }

    @Override
    void likePost(ObjectId postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post with id " + postId + " not found"))
        post.incrementLikes()
        postRepository.save(post)
    }

    @Override
    void unlikePost(ObjectId postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post with id " + postId + " not found"))
        post.decrementLikes()
        postRepository.save(post)
    }
}
