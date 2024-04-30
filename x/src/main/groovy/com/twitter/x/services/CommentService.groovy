package com.twitter.x.services

import com.twitter.x.entities.Comment
import org.bson.types.ObjectId

interface CommentService {

    List<Comment> getAllComments()
    Comment getCommentById(ObjectId id)
    Comment createComment(Comment comment)
    void updateComment(Comment comment)
    void deleteComment(ObjectId id)
    List<Comment> getCommentsByPostId(ObjectId postId)
}