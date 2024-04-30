//package com.twitter.x.configs
//
//import com.twitter.x.entities.User
//import com.twitter.x.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder
//
//@Configuration
//class ApplicationConfig {
//
//    @Autowired
//    private final UserRepository userRepository;
//
//    @Bean
//    UserDetailsService userDetailsService() {
//        return (email) -> {
//            Optional<User> userOptional = userRepository.findByEmail(email);
//            return userOptional.map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        };
//    }
//
//    @Bean
//    AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider()
//        authProvider.setUserDetailsService(userDetailsService())
//        authProvider.setPasswordEncoder(passwordEncoder())
//        return authProvider
//    }
//
//    @Bean
//    static AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager()
//    }
//
//    @Bean
//    static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder()
//    }
//}
