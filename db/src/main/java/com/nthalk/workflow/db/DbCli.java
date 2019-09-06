package com.nthalk.workflow.db;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import org.docopt.Docopt;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

public class DbCli {

  public static void main(String[] args) throws IOException {
    Docopt docopt = new Docopt(DbCli.class.getClassLoader().getResourceAsStream("DbCli.docopt"));
    docopt.withHelp(true);

    Properties build = new Properties();
    build.load(DbCli.class.getClassLoader().getResourceAsStream("build.properties"));
    docopt.withVersion(build.getProperty("build.version"));

    Map<String, Object> opts = docopt.parse(args);
    if ((Boolean) opts.get("migrate")) {
      migrate(
          opts.get("--jdbcurl").toString(),
          opts.get("--user").toString(),
          opts.get("--pass").toString());
    }
  }

  public static void migrate(String jdbcurl, String user, String password) {
    Flyway flyway =
        new Flyway(
            new FluentConfiguration()
                .dataSource(jdbcurl, user, password)
                .locations("classpath:/db"));
    migrate(flyway);
  }

  public static void migrate(DataSource dataSource) {
    Flyway flyway =
        new Flyway(new FluentConfiguration().dataSource(dataSource).locations("classpath:/db"));
    migrate(flyway);
  }

  private static void migrate(Flyway flyway) {
    System.out.print("Migrating database... ");
    flyway.migrate();
    System.out.println("Migrated.");
  }
}
