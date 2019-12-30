package com.nthalk.webstack.web.controllers

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class WsTestController {
    @MessageMapping("/ws-test/message")
    @SendTo("/topic/ws-test")
    @Throws(Exception::class)
    fun greeting(message: String): String {
        Thread.sleep(1000)
        return message
    }
}
