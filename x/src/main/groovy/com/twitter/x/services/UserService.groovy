package com.twitter.x.services

import com.twitter.x.entities.User
import org.bson.types.ObjectId

interface UserService {

    User createUser(User user)
    List<User> getAllUsers()
    User getUserById(ObjectId id)
    void updateUser(User user)
    void deleteUser(ObjectId id)
    void subscribeToUser(ObjectId userId, ObjectId targetUserId)
    void unsubscribeFromUser(ObjectId userId, ObjectId targetUserId)
}