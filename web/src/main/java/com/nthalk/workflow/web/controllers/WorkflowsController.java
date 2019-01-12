package com.nthalk.workflow.web.controllers;

import com.nthalk.workflow.db.models.Tables;
import com.nthalk.workflow.db.models.tables.pojos.Workflow;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/workflows")
public class WorkflowsController {

  @Autowired DSLContext db;

  @PostMapping
  @ResponseBody
  List<Workflow> workflows() {
    return db.select().from(Tables.WORKFLOW).fetchInto(Workflow.class);
  }
}
