package com.example.meetup

import org.springframework.data.repository.query.Param
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
interface PersonRepository : MongoRepository<User, String> {

    fun findByNameLike(@Param("name") name: String): MutableList<User>

}