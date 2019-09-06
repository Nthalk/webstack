import produce from "immer"
import React from "react";

export interface ApiService {
  post: (url: string, data: any) => Promise<Response>
}

export interface ApiState extends ApiService {
  activeRequests: Array<Promise<Response>>,
  defaultUrl: string
}

export const ApiContext = React.createContext<ApiService>(null);
export const ApiStateContext = React.createContext<ApiState>(null);

export class Api extends React.Component<{}, ApiState> {
  update(cb: (ApiStateType) => void) {
    return this.setState(produce(this.state, s => {
      cb(s)
    }));
  }

  async post(url: string, data: any) {
    url = this.state.defaultUrl + url;
    let responsePromise = fetch(new Request(url, {method: "post", body: JSON.stringify(data)}));
    this.update((s) => s.activeRequests.push(responsePromise));
    try {
      let response = await responsePromise;
      let json = await response.json();
      this.update((s) => {
        s.activeRequests.splice(s.activeRequests.indexOf(responsePromise), 1)
      });
      return json;
    } catch (e) {
      this.update((s) => {
        s.activeRequests.splice(s.activeRequests.indexOf(responsePromise), 1)
      });
    }
  }

  state = {
    post: this.post.bind(this),
    activeRequests: [],
    defaultUrl: location.protocol + '//' +
        location.hostname +
        (location.port ? ":" + location.port : "") +
        location.pathname
  };

  render() {
    return <ApiStateContext.Provider value={this.state}>
      <ApiContext.Provider value={this}>
        {this.props.children}
      </ApiContext.Provider>
    </ApiStateContext.Provider>
  }
}
