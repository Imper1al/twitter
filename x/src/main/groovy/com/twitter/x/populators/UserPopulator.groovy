package com.twitter.x.populators

import com.twitter.x.entities.User
import org.springframework.stereotype.Component

@Component
class UserPopulator {

        UserPopulator() {}

        User populateUser(User user, User existingUser) {

            existingUser.setUsername(user.getUsername())
            existingUser.setPassword(user.getPassword())
            existingUser.setEmail(user.getEmail())
            existingUser.setFollowers(user.getFollowers())
            existingUser.setRegistrationDate(user.getRegistrationDate())
            existingUser.setSubscriptions(user.getSubscriptions())
            existingUser.setRole(user.getRole())

            return existingUser
    }
}
