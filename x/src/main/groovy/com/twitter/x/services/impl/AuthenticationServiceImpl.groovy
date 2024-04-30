//package com.twitter.x.services.impl
//
//import com.twitter.x.configs.services.JwtService
//import com.twitter.x.dtos.AuthenticationRequest
//import com.twitter.x.dtos.AuthenticationResponse
//import com.twitter.x.dtos.RegisterRequest
//import com.twitter.x.entities.Role
//import com.twitter.x.entities.User
//import com.twitter.x.repositories.UserRepository
//import com.twitter.x.services.AuthenticationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service
//
//@Service
//class AuthenticationServiceImpl implements AuthenticationService {
//
//    @Autowired
//    private final UserRepository userRepository
//    @Autowired
//    private final PasswordEncoder passwordEncoder
//    @Autowired
//    private final JwtService jwtService
//    @Autowired
//    private final AuthenticationManager authenticationManager
//
//    @Override
//    AuthenticationResponse register(RegisterRequest request) {
//        var user = User.builder()
//                .username(request.getProperty("username"))
//                .email(request.getProperty("email"))
//                .password(passwordEncoder.encode(request.getProperty("password")))
//                .role(Role.USER)
//                .registrationDate(new Date())
//                .build();
//        userRepository.save(user)
//        var jwtToken = jwtService.generateToken(user)
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build()
//    }
//
//    @Override
//    AuthenticationResponse authentication(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getProperty("email"), request.getProperty("password")
//                )
//        )
//        var user = userRepository.findByEmail(request.getProperty("email"))
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"))
//        var jwtToken = jwtService.generateToken(user)
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build()
//    }
//}
