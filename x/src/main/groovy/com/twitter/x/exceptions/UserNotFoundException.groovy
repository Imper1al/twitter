package com.twitter.x.exceptions

class UserNotFoundException extends RuntimeException {

    UserNotFoundException(String message) {
        super(message)
    }
}