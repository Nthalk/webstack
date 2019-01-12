import React from "react"
import ReactDOM from "react-dom"
import {App} from "./app";

let root = document.getElementById('main');
if (root != null) {
  ReactDOM.render(
      <App/>,
      root
  );
}
