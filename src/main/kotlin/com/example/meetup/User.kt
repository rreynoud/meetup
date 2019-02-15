package com.example.meetup

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.Size

@Document
class User {

    @Id
    var id: String? = null

    @Indexed(unique = true)
    var email: String? = null

    @Size(min = 6)
    var name: String? = null
}