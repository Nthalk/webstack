package com.nthalk.webstack.web.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsTestController {
  @MessageMapping("/ws-test/message")
  @SendTo("/topic/ws-test")
  public String greeting(String message) throws Exception {
    Thread.sleep(1000);
    return message;
  }
}
