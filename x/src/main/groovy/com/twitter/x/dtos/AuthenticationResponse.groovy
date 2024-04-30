//package com.twitter.x.dtos
//
//import groovy.transform.Canonical
//import groovy.transform.TupleConstructor
//
//@TupleConstructor
//@Canonical
//class AuthenticationResponse {
//
//    private String token
//
//    static Builder builder() {
//        return new Builder()
//    }
//
//    String getToken() {
//        return token
//    }
//
//    void setToken(String token) {
//        this.token = token
//    }
//}
//
//class Builder {
//
//    private String token
//
//    Builder token(String token) {
//        this.token = token
//        return this
//    }
//
//    AuthenticationResponse build() {
//        return new AuthenticationResponse(token: token)
//    }
//}
//
