package com.nthalk.webstack.web.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@ConfigurationProperties(prefix = "app")
public class AppConfig {

  @Bean
  public String getHome() {
    return System.getProperty("home", "./home");
  }

  public static class ClusterNode {
    String id;
    String host;
    Integer port = 5679;

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getHost() {
      return host;
    }

    public void setHost(String host) {
      this.host = host;
    }

    public Integer getPort() {
      return port;
    }

    public void setPort(Integer port) {
      this.port = port;
    }
  }
}
