package com.nthalk.workflow.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import org.docopt.Docopt;
import org.flywaydb.core.Flyway;
import org.h2.Driver;
import org.h2.tools.Server;

public class DbCli {

  public static void main(String[] args) throws SQLException, IOException {
    Docopt docopt = new Docopt(DbCli.class.getClassLoader().getResourceAsStream("DbCli.docopt"));
    docopt.withHelp(true);

    Properties build = new Properties();
    build.load(DbCli.class.getClassLoader().getResourceAsStream("build.properties"));
    docopt.withVersion(build.getProperty("build.version"));

    Map<String, Object> opts = docopt.parse(args);
    String db = String.valueOf(opts.get("--db"));
    String port = String.valueOf(opts.get("--port"));
    if ((Boolean) opts.get("start")) {
      System.out.print("Starting h2 database... ");
      start(db, port);
      System.out.println("Started.");

      if ((Boolean) opts.get("--migrate")) {
        migrate("jdbc:h2:tcp://localhost:" + port + "/" + db);
      }
    } else if ((Boolean) opts.get("migrate")) {
      migrate("jdbc:h2:tcp://localhost:" + port + "/" + db);
    }
  }

  public static void migrate(String jdbcurl) {
    Flyway flyway = new Flyway();
    flyway.setDataSource(jdbcurl, null, null);
    migrate(flyway);
  }

  public static void migrate(DataSource dataSource) {
    Flyway flyway = new Flyway();
    flyway.setDataSource(dataSource);
    migrate(flyway);
  }

  private static void migrate(Flyway flyway) {
    System.out.print("Migrating database... ");
    flyway.setLocations("classpath:/db");
    System.out.println("Migrated.");
    flyway.migrate();
  }

  public static String start(String h2Db, String port) throws SQLException {
    Driver.load().connect("jdbc:h2:" + h2Db + ";DB_CLOSE_DELAY=-1", new Properties());
    String jdbcurl = Server.createTcpServer("-tcpPort", port, "-tcpAllowOthers").start().getURL();
    jdbcurl = "jdbc:h2:" + jdbcurl + "/" + h2Db;
    return jdbcurl;
  }
}
