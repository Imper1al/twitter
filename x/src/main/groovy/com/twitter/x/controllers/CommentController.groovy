package com.twitter.x.controllers

import com.twitter.x.entities.Comment
import com.twitter.x.services.impl.CommentServiceImpl
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts/{postId}/comments")
class CommentController {

    @Autowired
    private final CommentServiceImpl commentService

    @GetMapping
    List<Comment> getCommentsByPostId(@PathVariable(name = "postId") ObjectId postId) {
        return commentService.getCommentsByPostId(postId)
    }

    @PostMapping
    ResponseEntity<Comment> createComment(@PathVariable(name = "postId") ObjectId postId, @RequestBody Comment comment, @RequestParam("userId") ObjectId userId) {
        comment.setPostId(postId)
        comment.setUserId(userId)
        Comment createdComment = commentService.createComment(comment)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment)
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateComment(@PathVariable(name = "id") ObjectId id, @RequestBody Comment comment) {
        comment.setId(id)
        commentService.updateComment(comment)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteComment(@PathVariable(name = "id") ObjectId id) {
        commentService.deleteComment(id)
        return ResponseEntity.noContent().build()
    }
}
