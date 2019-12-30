package com.nthalk.webstack.web.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/test")
@RestController
class TestApi {
    class Pong {
        val pong: String get() = "pong"
    }

    @PostMapping
    fun ping(): ApiResult<Pong> {
        return ApiResult(Pong())
    }
}
