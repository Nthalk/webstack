package com.nthalk.webstack.web.controllers

import com.nthalk.webstack.db.models.Tables
import com.nthalk.webstack.web.controllers.models.Workflow
import org.jooq.DSLContext
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/workflows")
class WorkflowsController(val db: DSLContext) {
    @PostMapping
    @ResponseBody
    fun workflows(): List<Workflow> {
        return db.select().from(Tables.WORKFLOW).fetchInto(Workflow::class.java)
    }
}
