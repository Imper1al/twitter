package com.twitter.x.controllers

import com.twitter.x.dtos.AuthenticationResponse
import com.twitter.x.dtos.RegisterRequest
import com.twitter.x.entities.Role
import com.twitter.x.entities.User
import com.twitter.x.entities.UserProfile
import org.bson.types.ObjectId
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import spock.lang.Specification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.util.mop.Use

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest extends Specification {

    @LocalServerPort
    private int port = 8082

    String baseUrl = "http://localhost:" + port

    private final TestRestTemplate restTemplate = new TestRestTemplate()

    def "Test get all users endpoint"() {
        given:
        def expectedStatusCode = HttpStatus.OK

        when:
        ResponseEntity<List> response = restTemplate.getForEntity(baseUrl + "/api/users", List)

        then:
        response.statusCode == expectedStatusCode
        response.body.size() > 0
    }

    def "Test get user by id endpoint"() {
        given:
        ObjectId userId = registerNewUser()
        def expectedStatusCode = HttpStatus.OK

        when:
        ResponseEntity<User> response = restTemplate.getForEntity(baseUrl + "/api/users/$userId", User)

        then:
        response.statusCode == expectedStatusCode
        response.body.id == userId
    }

    def "Test update user endpoint"() {
        given:
        ObjectId userId = new ObjectId("60735a4d64a5b50c5055e7fc")
        def updatedUser = User.builder()
                .id(userId)
                .username("updatedUsername")
                .email("updatedEmail@example.com")
                .password("test")
                .role(Role.USER)
                .build();
        def expectedStatusCode = HttpStatus.NO_CONTENT

        when:
        ResponseEntity<Void> response = restTemplate.exchange(baseUrl + "/api/users/$userId", HttpMethod.PUT, new HttpEntity<>(updatedUser), Void.class)

        then:
        response.statusCode == expectedStatusCode
    }

    def "Test subscribe to user endpoint"() {
        given:
        ObjectId userId = new ObjectId("60735a4d64a5b50c5055e7fc")
        ObjectId targetUserId = new ObjectId("60735a4d64a5b50c5055e7fd")
        def expectedStatusCode = HttpStatus.NO_CONTENT

        when:
        ResponseEntity<Void> response = restTemplate.exchange(baseUrl + "/api/users/$userId/subscribe/$targetUserId", HttpMethod.PUT, null, Void.class)

        then:
        response.statusCode == expectedStatusCode
    }

    def "Test unsubscribe from user endpoint"() {
        given:
        ObjectId userId = new ObjectId("60735a4d64a5b50c5055e7fc")
        ObjectId targetUserId = new ObjectId("60735a4d64a5b50c5055e7fd")
        def expectedStatusCode = HttpStatus.NO_CONTENT

        when:
        ResponseEntity<Void> response = restTemplate.exchange(baseUrl + "/api/users/$userId/unsubscribe/$targetUserId", HttpMethod.PUT, null, Void.class)

        then:
        response.statusCode == expectedStatusCode
    }

    def "Test get user profile endpoint"() {
        given:
        ObjectId userId = registerNewUser()
        def expectedStatusCode = HttpStatus.OK

        when:
        ResponseEntity<UserProfile> response = restTemplate.getForEntity(baseUrl + "/api/users/$userId/profile", UserProfile)

        then:
        response.statusCode == expectedStatusCode
        response.body.user.id == userId
        response.body.postDetailsList.size() > 0
    }

    def "Test delete user endpoint"() {
        given:
        ObjectId userId = new ObjectId("60735a4d64a5b50c5055e7fc")
        def expectedStatusCode = HttpStatus.NO_CONTENT

        when:
        ResponseEntity<Void> response = restTemplate.exchange(baseUrl + "/api/users/$userId", HttpMethod.DELETE, null, Void.class)

        then:
        response.statusCode == expectedStatusCode
    }

    ObjectId registerNewUser() {
        RegisterRequest request = new RegisterRequest("username", "email", "password")
        ResponseEntity<User> userCreationResponse = restTemplate.postForEntity(baseUrl + "/api/users", request, User)
        if (userCreationResponse.statusCode == HttpStatus.OK) {
            return userCreationResponse.body.userId
        } else {
            throw new RuntimeException("Failed to create new user. Status code: ${userCreationResponse.statusCode}")
        }
    }
}