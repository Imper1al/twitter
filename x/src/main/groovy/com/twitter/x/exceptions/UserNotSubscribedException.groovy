package com.twitter.x.exceptions

class UserNotSubscribedException extends RuntimeException {

    UserNotSubscribedException(String message) {
        super(message)
    }
}
