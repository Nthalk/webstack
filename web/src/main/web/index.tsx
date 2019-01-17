import React from "react"
import ReactDOM from "react-dom"
import {App} from "./app";

import SockJS from "sockjs-client";
import Stomp from "stompjs"


var websocket = SockJS("/ws");
var stomp = Stomp.over(websocket);

window.stomp = stomp;
stomp.connect({}, () => {
  stomp.subscribe("/topic/ws-test", () => {
    debugger
  });
  stomp.send("/app/ws-test/message", {}, "message");
});

let root = document.getElementById('main');
if (root != null) {
  ReactDOM.render(
      <App/>,
      root
  );
}
