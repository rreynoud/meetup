package com.example.meetup

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String>