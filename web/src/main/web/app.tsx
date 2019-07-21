import React from "react"
import {Workflow} from "../../../gen/typescript/api";
import produce from 'immer';
import {ApiService} from "./lib/api";


type AppState = {
  edit: Workflow
};

export class App extends React.Component<{ api: ApiService }, AppState> {
  update = (s: (AppState) => void) => this.setState(produce(this.state, s));

  state = {
    edit: {name: "asdf"}
  };

  save = async (event) => {
    event.preventDefault();
    return await this.props.api.post("workflows", this.state.edit);
  };

  updateWorkflowName = (event) => {
    this.update(s => {
      s.edit.name = event.target.value
    })
  };

  render() {
    return <form onSubmit={this.save}>
      <label>Name: </label>
      <input type="text"
             value={this.state.edit.name}
             onChange={this.updateWorkflowName}/>
      <button>Submit</button>
    </form>
  }
}
