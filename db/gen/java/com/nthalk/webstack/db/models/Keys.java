/*
 * This file is generated by jOOQ.
 */
package com.nthalk.webstack.db.models;


import com.nthalk.webstack.db.models.tables.FlywaySchemaHistory;
import com.nthalk.webstack.db.models.tables.Workflow;
import com.nthalk.webstack.db.models.tables.WorkflowState;
import com.nthalk.webstack.db.models.tables.WorkflowTransition;
import com.nthalk.webstack.db.models.tables.WorkflowTransitionEvent;
import com.nthalk.webstack.db.models.tables.records.FlywaySchemaHistoryRecord;
import com.nthalk.webstack.db.models.tables.records.WorkflowRecord;
import com.nthalk.webstack.db.models.tables.records.WorkflowStateRecord;
import com.nthalk.webstack.db.models.tables.records.WorkflowTransitionEventRecord;
import com.nthalk.webstack.db.models.tables.records.WorkflowTransitionRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code></code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<WorkflowRecord, Integer> IDENTITY_WORKFLOW = Identities0.IDENTITY_WORKFLOW;
    public static final Identity<WorkflowStateRecord, Integer> IDENTITY_WORKFLOW_STATE = Identities0.IDENTITY_WORKFLOW_STATE;
    public static final Identity<WorkflowTransitionRecord, Integer> IDENTITY_WORKFLOW_TRANSITION = Identities0.IDENTITY_WORKFLOW_TRANSITION;
    public static final Identity<WorkflowTransitionEventRecord, Integer> IDENTITY_WORKFLOW_TRANSITION_EVENT = Identities0.IDENTITY_WORKFLOW_TRANSITION_EVENT;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = UniqueKeys0.FLYWAY_SCHEMA_HISTORY_PK;
    public static final UniqueKey<WorkflowRecord> WORKFLOW_PKEY = UniqueKeys0.WORKFLOW_PKEY;
    public static final UniqueKey<WorkflowRecord> WORKFLOW_NAME_KEY = UniqueKeys0.WORKFLOW_NAME_KEY;
    public static final UniqueKey<WorkflowStateRecord> WORKFLOW_STATE_PKEY = UniqueKeys0.WORKFLOW_STATE_PKEY;
    public static final UniqueKey<WorkflowTransitionRecord> WORKFLOW_TRANSITION_PKEY = UniqueKeys0.WORKFLOW_TRANSITION_PKEY;
    public static final UniqueKey<WorkflowTransitionEventRecord> WORKFLOW_TRANSITION_EVENT_PKEY = UniqueKeys0.WORKFLOW_TRANSITION_EVENT_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<WorkflowStateRecord, WorkflowRecord> WORKFLOW_STATE__WORKFLOW_STATE_WORKFLOW_ID_FKEY = ForeignKeys0.WORKFLOW_STATE__WORKFLOW_STATE_WORKFLOW_ID_FKEY;
    public static final ForeignKey<WorkflowTransitionRecord, WorkflowRecord> WORKFLOW_TRANSITION__WORKFLOW_TRANSITION_WORKFLOW_ID_FKEY = ForeignKeys0.WORKFLOW_TRANSITION__WORKFLOW_TRANSITION_WORKFLOW_ID_FKEY;
    public static final ForeignKey<WorkflowTransitionRecord, WorkflowStateRecord> WORKFLOW_TRANSITION__WORKFLOW_TRANSITION_FROM_WORKFLOW_STATE_ID_FKEY = ForeignKeys0.WORKFLOW_TRANSITION__WORKFLOW_TRANSITION_FROM_WORKFLOW_STATE_ID_FKEY;
    public static final ForeignKey<WorkflowTransitionRecord, WorkflowStateRecord> WORKFLOW_TRANSITION__WORKFLOW_TRANSITION_TO_WORKFLOW_STATE_ID_FKEY = ForeignKeys0.WORKFLOW_TRANSITION__WORKFLOW_TRANSITION_TO_WORKFLOW_STATE_ID_FKEY;
    public static final ForeignKey<WorkflowTransitionEventRecord, WorkflowTransitionRecord> WORKFLOW_TRANSITION_EVENT__WORKFLOW_TRANSITION_EVENT_WORKFLOW_TRANSITION_ID_FKEY = ForeignKeys0.WORKFLOW_TRANSITION_EVENT__WORKFLOW_TRANSITION_EVENT_WORKFLOW_TRANSITION_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<WorkflowRecord, Integer> IDENTITY_WORKFLOW = Internal.createIdentity(Workflow.WORKFLOW, Workflow.WORKFLOW.WORKFLOW_ID);
        public static Identity<WorkflowStateRecord, Integer> IDENTITY_WORKFLOW_STATE = Internal.createIdentity(WorkflowState.WORKFLOW_STATE, WorkflowState.WORKFLOW_STATE.WORKFLOW_STATE_ID);
        public static Identity<WorkflowTransitionRecord, Integer> IDENTITY_WORKFLOW_TRANSITION = Internal.createIdentity(WorkflowTransition.WORKFLOW_TRANSITION, WorkflowTransition.WORKFLOW_TRANSITION.WORKFLOW_TRANSITION_ID);
        public static Identity<WorkflowTransitionEventRecord, Integer> IDENTITY_WORKFLOW_TRANSITION_EVENT = Internal.createIdentity(WorkflowTransitionEvent.WORKFLOW_TRANSITION_EVENT, WorkflowTransitionEvent.WORKFLOW_TRANSITION_EVENT.WORKFLOW_TRANSITION_EVENT_ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "flyway_schema_history_pk", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK);
        public static final UniqueKey<WorkflowRecord> WORKFLOW_PKEY = Internal.createUniqueKey(Workflow.WORKFLOW, "workflow_pkey", Workflow.WORKFLOW.WORKFLOW_ID);
        public static final UniqueKey<WorkflowRecord> WORKFLOW_NAME_KEY = Internal.createUniqueKey(Workflow.WORKFLOW, "workflow_name_key", Workflow.WORKFLOW.NAME);
        public static final UniqueKey<WorkflowStateRecord> WORKFLOW_STATE_PKEY = Internal.createUniqueKey(WorkflowState.WORKFLOW_STATE, "workflow_state_pkey", WorkflowState.WORKFLOW_STATE.WORKFLOW_STATE_ID);
        public static final UniqueKey<WorkflowTransitionRecord> WORKFLOW_TRANSITION_PKEY = Internal.createUniqueKey(WorkflowTransition.WORKFLOW_TRANSITION, "workflow_transition_pkey", WorkflowTransition.WORKFLOW_TRANSITION.WORKFLOW_TRANSITION_ID);
        public static final UniqueKey<WorkflowTransitionEventRecord> WORKFLOW_TRANSITION_EVENT_PKEY = Internal.createUniqueKey(WorkflowTransitionEvent.WORKFLOW_TRANSITION_EVENT, "workflow_transition_event_pkey", WorkflowTransitionEvent.WORKFLOW_TRANSITION_EVENT.WORKFLOW_TRANSITION_EVENT_ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<WorkflowStateRecord, WorkflowRecord> WORKFLOW_STATE__WORKFLOW_STATE_WORKFLOW_ID_FKEY = Internal.createForeignKey(com.nthalk.webstack.db.models.Keys.WORKFLOW_PKEY, WorkflowState.WORKFLOW_STATE, "workflow_state__workflow_state_workflow_id_fkey", WorkflowState.WORKFLOW_STATE.WORKFLOW_ID);
        public static final ForeignKey<WorkflowTransitionRecord, WorkflowRecord> WORKFLOW_TRANSITION__WORKFLOW_TRANSITION_WORKFLOW_ID_FKEY = Internal.createForeignKey(com.nthalk.webstack.db.models.Keys.WORKFLOW_PKEY, WorkflowTransition.WORKFLOW_TRANSITION, "workflow_transition__workflow_transition_workflow_id_fkey", WorkflowTransition.WORKFLOW_TRANSITION.WORKFLOW_ID);
        public static final ForeignKey<WorkflowTransitionRecord, WorkflowStateRecord> WORKFLOW_TRANSITION__WORKFLOW_TRANSITION_FROM_WORKFLOW_STATE_ID_FKEY = Internal.createForeignKey(com.nthalk.webstack.db.models.Keys.WORKFLOW_STATE_PKEY, WorkflowTransition.WORKFLOW_TRANSITION, "workflow_transition__workflow_transition_from_workflow_state_id_fkey", WorkflowTransition.WORKFLOW_TRANSITION.FROM_WORKFLOW_STATE_ID);
        public static final ForeignKey<WorkflowTransitionRecord, WorkflowStateRecord> WORKFLOW_TRANSITION__WORKFLOW_TRANSITION_TO_WORKFLOW_STATE_ID_FKEY = Internal.createForeignKey(com.nthalk.webstack.db.models.Keys.WORKFLOW_STATE_PKEY, WorkflowTransition.WORKFLOW_TRANSITION, "workflow_transition__workflow_transition_to_workflow_state_id_fkey", WorkflowTransition.WORKFLOW_TRANSITION.TO_WORKFLOW_STATE_ID);
        public static final ForeignKey<WorkflowTransitionEventRecord, WorkflowTransitionRecord> WORKFLOW_TRANSITION_EVENT__WORKFLOW_TRANSITION_EVENT_WORKFLOW_TRANSITION_ID_FKEY = Internal.createForeignKey(com.nthalk.webstack.db.models.Keys.WORKFLOW_TRANSITION_PKEY, WorkflowTransitionEvent.WORKFLOW_TRANSITION_EVENT, "workflow_transition_event__workflow_transition_event_workflow_transition_id_fkey", WorkflowTransitionEvent.WORKFLOW_TRANSITION_EVENT.WORKFLOW_TRANSITION_ID);
    }
}