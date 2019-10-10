package com.nthalk.webstack.web.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/ping")
@RestController
public class PingApi {

  @PostMapping
  public Pong ping() {
    return new Pong();
  }

  public static class Pong {
    public String getPong() {
      return "pong";
    }
  }
}
