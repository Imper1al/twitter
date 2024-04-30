package com.twitter.x.repositories

import com.twitter.x.entities.Comment
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository extends MongoRepository<Comment, ObjectId> {

    List<Comment> findByPostId(ObjectId postId)
}