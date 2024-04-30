package com.twitter.x.repositories

import com.twitter.x.entities.Post
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository extends MongoRepository<Post, ObjectId> {

    List<Post> findByUserId(userId)
}