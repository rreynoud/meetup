package com.example.meetup

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/test-connection")
class TestConnectionController {
    @GetMapping
    fun all(): ResponseEntity<Any> {
        return ResponseEntity.ok(DummyResponse())
    }

    inner class DummyResponse(val name: String = "That Work's :D")
}