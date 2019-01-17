/*
 * This file is generated by jOOQ.
 */
package com.nthalk.workflow.db.models.tables.records;


import com.nthalk.workflow.db.models.tables.WorkflowTransition;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class WorkflowTransitionRecord extends UpdatableRecordImpl<WorkflowTransitionRecord> implements Record5<Integer, Integer, String, Integer, Integer> {

    private static final long serialVersionUID = 434579472;

    /**
     * Setter for <code>workflow_transition.workflow_transition_id</code>.
     */
    public void setWorkflowTransitionId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>workflow_transition.workflow_transition_id</code>.
     */
    public Integer getWorkflowTransitionId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>workflow_transition.workflow_id</code>.
     */
    public void setWorkflowId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>workflow_transition.workflow_id</code>.
     */
    public Integer getWorkflowId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>workflow_transition.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>workflow_transition.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>workflow_transition.from_workflow_state_id</code>.
     */
    public void setFromWorkflowStateId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>workflow_transition.from_workflow_state_id</code>.
     */
    public Integer getFromWorkflowStateId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>workflow_transition.to_workflow_state_id</code>.
     */
    public void setToWorkflowStateId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>workflow_transition.to_workflow_state_id</code>.
     */
    public Integer getToWorkflowStateId() {
        return (Integer) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Integer, String, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Integer, String, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return WorkflowTransition.WORKFLOW_TRANSITION.WORKFLOW_TRANSITION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return WorkflowTransition.WORKFLOW_TRANSITION.WORKFLOW_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return WorkflowTransition.WORKFLOW_TRANSITION.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return WorkflowTransition.WORKFLOW_TRANSITION.FROM_WORKFLOW_STATE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return WorkflowTransition.WORKFLOW_TRANSITION.TO_WORKFLOW_STATE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getWorkflowTransitionId();
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
    public Integer component4() {
        return getFromWorkflowStateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getToWorkflowStateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getWorkflowTransitionId();
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
    public Integer value4() {
        return getFromWorkflowStateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getToWorkflowStateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WorkflowTransitionRecord value1(Integer value) {
        setWorkflowTransitionId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WorkflowTransitionRecord value2(Integer value) {
        setWorkflowId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WorkflowTransitionRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WorkflowTransitionRecord value4(Integer value) {
        setFromWorkflowStateId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WorkflowTransitionRecord value5(Integer value) {
        setToWorkflowStateId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WorkflowTransitionRecord values(Integer value1, Integer value2, String value3, Integer value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WorkflowTransitionRecord
     */
    public WorkflowTransitionRecord() {
        super(WorkflowTransition.WORKFLOW_TRANSITION);
    }

    /**
     * Create a detached, initialised WorkflowTransitionRecord
     */
    public WorkflowTransitionRecord(Integer workflowTransitionId, Integer workflowId, String name, Integer fromWorkflowStateId, Integer toWorkflowStateId) {
        super(WorkflowTransition.WORKFLOW_TRANSITION);

        set(0, workflowTransitionId);
        set(1, workflowId);
        set(2, name);
        set(3, fromWorkflowStateId);
        set(4, toWorkflowStateId);
    }
}
