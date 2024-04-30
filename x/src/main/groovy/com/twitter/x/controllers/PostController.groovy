package com.twitter.x.controllers

import com.twitter.x.entities.Post
import com.twitter.x.services.impl.PostServiceImpl
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts")
class PostController {

    @Autowired
    private final PostServiceImpl postService

    @GetMapping
    List<Post> getAllPosts() {
        postService.getAllPosts()
    }

    @GetMapping("/{id}")
    ResponseEntity<Post> getPostById(@PathVariable(name = "id") ObjectId id) {
        Post post = postService.getPostById(id)
        return post ? ResponseEntity.ok(post) : ResponseEntity.notFound().build() as ResponseEntity<Post>
    }

    @PostMapping
    ResponseEntity<Post> createPost(@RequestBody Post post, @RequestParam("userId") ObjectId userId) {
        post.setUserId(userId)
        Post createdPost = postService.createPost(post)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost)
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updatePost(@PathVariable(name = "id") ObjectId id, @RequestBody Post post) {
        post.setId(id)
        postService.updatePost(post)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/{postId}/like")
    ResponseEntity<?> likePost(@PathVariable(name = "postId") ObjectId postId) {
        postService.likePost(postId)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/{postId}/unlike")
    ResponseEntity<?> unlikePost(@PathVariable(name = "postId") ObjectId postId) {
        postService.unlikePost(postId)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePost(@PathVariable(name = "id") ObjectId id) {
        postService.deletePost(id)
        return ResponseEntity.noContent().build()
    }
}