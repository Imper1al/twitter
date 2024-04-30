package com.twitter.x.exceptions

class PostNotFoundException extends RuntimeException {

    PostNotFoundException(String message) {
        super(message)
    }
}