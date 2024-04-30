package com.twitter.x.services

import com.twitter.x.dtos.AuthenticationRequest
import com.twitter.x.dtos.AuthenticationResponse
import com.twitter.x.dtos.RegisterRequest

interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request)
    AuthenticationResponse authentication(AuthenticationRequest request)
}