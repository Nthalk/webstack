import React, {useContext, useEffect} from "react";
import * as api from "../gen/api"

export default class Api extends React.Component<{}, {}> {
  static Context = React.createContext<Api>(null);
  private httpClient = new class implements api.HttpClient {
    async request<R>(requestConfig: { method: string; url: string; queryParams?: any; data?: any; copyFn?: (data: R) => R; }): api.RestResponse<R> {
      const rsp = await fetch(requestConfig.url, {method: requestConfig.method});
      const json = await rsp.json();
      if (requestConfig.copyFn) {
        requestConfig.copyFn(json as R);
      }
      return json as R;
    }
  };

  public ping = new api.RestApplicationClient(this.httpClient);

  static use(cb: (api: Api) => any) {
    const api = useContext(Api.Context);
    useEffect(() => {
      cb(api);
    })
  }

  render() {
    return <Api.Context.Provider value={this}>
      {this.props.children}
    </Api.Context.Provider>
  }
}
