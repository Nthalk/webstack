import React from "react"
import Api from "./lib/api";

export default function App() {
  Api.use(async (api) => {
    const pong = await api.ping.ping();
    debugger
    console.log(pong.pong);
  });
  return (
      <>
        {"testing"}
      </>
  );
}
