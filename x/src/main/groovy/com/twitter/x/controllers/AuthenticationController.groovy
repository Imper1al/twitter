//package com.twitter.x.controllers
//
//import com.twitter.x.dtos.AuthenticationRequest
//import com.twitter.x.dtos.AuthenticationResponse
//import com.twitter.x.dtos.RegisterRequest
//import com.twitter.x.services.impl.AuthenticationServiceImpl
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//class AuthenticationController {
//
//    @Autowired
//    private final AuthenticationServiceImpl authService
//
//    @PostMapping("/register")
//    ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
//        return ResponseEntity.ok(authService.register(request))
//    }
//
//    @PostMapping("/authentication")
//    ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest request) {
//        return ResponseEntity.ok(authService.authentication(request))
//    }
//}