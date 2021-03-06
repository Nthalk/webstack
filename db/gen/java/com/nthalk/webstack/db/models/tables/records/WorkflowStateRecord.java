/*
 * This file is generated by jOOQ.
 */
package com.nthalk.webstack.db.models.tables.records;


import com.nthalk.webstack.db.models.tables.WorkflowState;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WorkflowStateRecord extends UpdatableRecordImpl<WorkflowStateRecord> implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = 1427167126;

    /**
     * Setter for <code>workflow_state.workflow_state_id</code>.
     */
    public void setWorkflowStateId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>workflow_state.workflow_state_id</code>.
     */
    public Integer getWorkflowStateId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>workflow_state.workflow_id</code>.
     */
    public void setWorkflowId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>workflow_state.workflow_id</code>.
     */
    public Integer getWorkflowId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>workflow_state.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>workflow_state.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return WorkflowState.WORKFLOW_STATE.WORKFLOW_STATE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return WorkflowState.WORKFLOW_STATE.WORKFLOW_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return WorkflowState.WORKFLOW_STATE.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getWorkflowStateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getWorkflowId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getWorkflowStateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getWorkflowId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WorkflowStateRecord value1(Integer value) {
        setWorkflowStateId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WorkflowStateRecord value2(Integer value) {
        setWorkflowId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WorkflowStateRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WorkflowStateRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WorkflowStateRecord
     */
    public WorkflowStateRecord() {
        super(WorkflowState.WORKFLOW_STATE);
    }

    /**
     * Create a detached, initialised WorkflowStateRecord
     */
    public WorkflowStateRecord(Integer workflowStateId, Integer workflowId, String name) {
        super(WorkflowState.WORKFLOW_STATE);

        set(0, workflowStateId);
        set(1, workflowId);
        set(2, name);
    }
}
