/* tslint:disable */

export interface Workflow extends WorkflowPojo {
}

export interface WorkflowPojo extends Serializable {
    workflowId?: number;
    name?: string;
    instanceTable?: string;
    instanceStateField?: string;
    instanceKeyField?: string;
}

export interface Serializable {
}
