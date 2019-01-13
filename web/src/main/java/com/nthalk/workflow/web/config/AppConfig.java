package com.nthalk.workflow.web.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@ConfigurationProperties(prefix = "app")
public class AppConfig {

  private ClusterConfig cluster;

  @Bean
  public String getHome() {
    return System.getProperty("home", "./home");
  }

  @Bean
  public ClusterConfig getCluster() {
    return cluster;
  }

  public void setCluster(ClusterConfig cluster) {
    this.cluster = cluster;
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

  public static class ClusterConfig extends ClusterNode {
    List<ClusterNode> nodes = new ArrayList<>();

    public List<ClusterNode> getNodes() {
      return nodes;
    }

    public void setNodes(List<ClusterNode> nodes) {
      this.nodes = nodes;
    }
  }
}
