package com.twitter.x.repositories

import com.twitter.x.entities.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByEmail(String email)
}