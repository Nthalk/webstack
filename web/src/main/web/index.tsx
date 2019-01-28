import * as ReactDOM from "react-dom"
import * as React from "react"
import {App} from "./app";

import SockJS from "sockjs-client";
import Stomp from "stompjs"


var websocket = SockJS("/ws");
var stomp = Stomp.over(websocket);

(window as any).stomp = stomp;

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
      root,
  );
}
