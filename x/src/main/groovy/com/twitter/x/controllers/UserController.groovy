package com.twitter.x.controllers

import com.twitter.x.dtos.RegisterRequest
import com.twitter.x.entities.Comment
import com.twitter.x.entities.Post
import com.twitter.x.entities.PostDetails
import com.twitter.x.entities.User
import com.twitter.x.entities.UserProfile
import com.twitter.x.exceptions.UserNotFoundException
import com.twitter.x.exceptions.UserNotSubscribedException
import com.twitter.x.services.CommentService
import com.twitter.x.services.PostService
import com.twitter.x.services.impl.UserServiceImpl
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController {

    @Autowired
    private final UserServiceImpl userService
    @Autowired
    private final PostService postService
    @Autowired
    private final CommentService commentService

    @GetMapping
    List<User> getAllUsers() {
        userService.getAllUsers()
    }

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody RegisterRequest request) {
        User user = userService.createUser(request.toUser())
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build()
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable(name = "id") ObjectId id) {
        User user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateUser(@PathVariable(name = "id") ObjectId id, @RequestBody User user) {
        user.setId(id)
        userService.updateUser(user)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{userId}/subscribe/{targetUserId}")
    ResponseEntity<Void> subscribeToUser(@PathVariable(name = "userId") ObjectId userId, @PathVariable(name = "targetUserId") ObjectId targetUserId) {
        try {
            userService.subscribeToUser(userId, targetUserId)
            return ResponseEntity.noContent().build()
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{userId}/unsubscribe/{targetUserId}")
    ResponseEntity<Void> unsubscribeFromUser(@PathVariable(name = "userId") ObjectId userId, @PathVariable(name = "targetUserId") ObjectId targetUserId) {
        try {
            userService.unsubscribeFromUser(userId, targetUserId)
            return ResponseEntity.noContent().build()
        } catch (UserNotFoundException | UserNotSubscribedException e) {
            return ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{userId}/profile")
    ResponseEntity<UserProfile> getUserProfile(@PathVariable(name = "userId") ObjectId userId) {
        User user = userService.getUserById(userId)
        List<Post> posts = postService.getPostsByUserId(userId)

        List<PostDetails> postDetailsList = new ArrayList<>()
        for (Post post : posts) {
            List<Comment> comments = commentService.getCommentsByPostId(post.getId())
            int likesCount = postService.getLikesCountByPostId(post.getId())
            PostDetails postDetails = new PostDetails(post, comments, likesCount)
            postDetailsList.add(postDetails)
        }

        UserProfile userProfile = new UserProfile(user, postDetailsList)
        return ResponseEntity.ok(userProfile)
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable(name = "id") ObjectId id) {
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }
}
