package com.twitter.x.configs

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.twitter.x.repositories")
class MongoConfig {

}