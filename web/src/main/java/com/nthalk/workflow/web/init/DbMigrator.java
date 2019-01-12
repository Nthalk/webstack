package com.nthalk.workflow.web.init;

import com.nthalk.workflow.db.DbCli;
import javax.sql.DataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbMigrator implements InitializingBean {

  @Autowired DataSource dataSource;

  public void afterPropertiesSet() {
    if ("true".equals(System.getProperty("migrate"))) {
      DbCli.migrate(dataSource);
    }
  }
}
