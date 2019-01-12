package com.nthalk.workflow.web;

import com.zaxxer.hikari.HikariDataSource;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import org.docopt.Docopt;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
    exclude = {FlywayAutoConfiguration.class, JooqAutoConfiguration.class},
    scanBasePackages = "com.nthalk.workflow.web")
public class WebCli {

  public static void main(String[] args) throws IOException {
    Docopt docopt = new Docopt(WebCli.class.getClassLoader().getResourceAsStream("WebCli.docopt"));
    docopt.withHelp(true);

    Properties build = new Properties();
    build.load(WebCli.class.getClassLoader().getResourceAsStream("build.properties"));
    docopt.withVersion(build.getProperty("build.version"));

    Map<String, Object> opts = docopt.parse(args);
    System.setProperty("server.port", (String) opts.get("--port"));
    System.setProperty("migrate", (Boolean) opts.get("--migrate") ? "true" : "false");

    SpringApplication.run(WebCli.class, args);
  }

  @Bean
  DataSource dataSource(@Value("${jdbc.url}") String jdbcurl) {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(jdbcurl);
    return dataSource;
  }

  @Bean
  DSLContext db(DataSource dataSource) {
    return new DefaultDSLContext(dataSource, SQLDialect.H2);
  }
}
