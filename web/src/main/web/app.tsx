import React from "react"
import {observer} from "mobx-react";
import {observable} from "mobx";
import {Workflow} from "../../../gen/typescript/api";
import api from "./lib/api";

@observer
export class App extends React.Component {

  constructor(props) {
    super(props)
  }

  @observable
  edit: Workflow = {
    name: ""
  };

  async save(event) {
    event.preventDefault();
    let response = await api.post("workflows", this.edit);
  }

  render() {
    return <div>
      <form onSubmit={this.save.bind(this)}>
        <label>Name:</label>
        <input type="text"
               value={this.edit.name}
               onChange={e => this.edit.name = e.target.value}/>
        <input type="submit"/>
      </form>
    </div>
  }
}
