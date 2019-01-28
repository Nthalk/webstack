import * as React from "react"
import {observer} from "mobx-react";
import {observable} from "mobx";
import {Workflow} from "../../../gen/typescript/api";
import api from "./lib/api";
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';


@observer
export class App extends React.Component {

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
      <CssBaseline/>
      <form onSubmit={this.save.bind(this)}>

        <label>Name:</label>
        <input type="text"
               value={this.edit.name}
               onChange={e => this.edit.name = e.target.value}/>
        <Button variant="contained" color="primary">
          Hello World
        </Button>
      </form>
    </div>
  }
}
