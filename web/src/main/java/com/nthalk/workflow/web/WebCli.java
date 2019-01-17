package com.nthalk.workflow.web;

import com.nthalk.workflow.web.config.AppConfig;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import org.docopt.Docopt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(
    exclude = {ErrorMvcAutoConfiguration.class},
    scanBasePackages = "com.nthalk.workflow.web")
@EnableConfigurationProperties(AppConfig.class)
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

    String home = System.getProperty("home", "./home");
    System.setProperty(
        "spring.config.location",
        "classpath:application.properties,file:" + home + "/application.properties");

    SpringApplication.run(WebCli.class, args);
  }
}
