package com.twitter.x.dtos

import com.twitter.x.entities.Role
import com.twitter.x.entities.User
import groovy.transform.Canonical
import groovy.transform.TupleConstructor

@TupleConstructor
@Canonical
class RegisterRequest {

    private String username
    private String email
    private String password

    RegisterRequest() {
    }

    RegisterRequest(String username, String email, String password) {
        this.username = username
        this.email = email
        this.password = password
    }

    String getUsername() {
        return username
    }

    void setUsername(String username) {
        this.username = username
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    void setPassword(String password) {
        this.password = password
    }

    String getPassword() {
        return password
    }

    User toUser() {
        return  User.builder()
                .username(username)
                .email(email)
                .password(password)
                .role(Role.USER)
                .build()
    }
}
