import React, {createContext, useContext, useMemo, useState} from 'react';
import {HttpClient, TestApiClient} from "../gen/api"

export type ApiState = {
  activeRequests: number;
  totalRequests: number;
};

class Api implements HttpClient {
  public token: string | void;
  public test = new TestApiClient(this);

  constructor(
      private setApiState: (modifier: (apiState: ApiState) => ApiState) => void
  ) {
  }

  public onRequestSuccess(): void {
    this.setApiState(apiState => ({
      ...apiState,
      totalRequests: apiState.totalRequests + 1,
      activeRequests: apiState.activeRequests + 1,
    }));
  }

  public onRequestError(): void {
    this.setApiState(apiState => ({
      ...apiState,
      activeRequests: apiState.activeRequests - 1,
    }));
  }

  public onRequestStart(): void {
    this.setApiState(apiState => ({
      ...apiState,
      activeRequests: apiState.activeRequests - 1,
    }));
  }

  /* eslint-disable @typescript-eslint/no-explicit-any */
  async request<R>(requestConfig: { method: string; url: string; queryParams?: any; data?: any; copyFn?: (data: R) => R }): Promise<R> {
    const {url, queryParams, method, data} = requestConfig;
    try {
      if (this.onRequestStart) {
        this.onRequestStart();
      }

      const headers: { [key: string]: string } = {
        'Content-Type': 'application/json',
        Accept: 'application/json',
      };

      if (this.token) {
        headers.Authorization = `Bearer ${this.token}`;
      }

      const response = await fetch(
          url +
          (queryParams
              ? `?${Object.keys(queryParams)
              .map(k => `${escape(k)}=${escape(queryParams[k])}`)
              .join('&')}`
              : ''),
          {
            method,
            headers,
            body: JSON.stringify(data),
          }
      );
      const json = await response.json();
      if (response.status >= 400) {
        // noinspection ExceptionCaughtLocallyJS
        throw json;
      }
      if (this.onRequestSuccess) {
        this.onRequestSuccess();
      }
      return (json as unknown) as R;
    } catch (e) {
      if (this.onRequestError) {
        this.onRequestError();
      }
      return ({error: e} as unknown) as R;
    }
  }

  /* eslint-enable @typescript-eslint/no-explicit-any */
}

const ApiContext = createContext<Api>(null as Api);
const ApiStateContext = createContext<ApiState>(null as ApiState);

export function useApi(): Api {
  return useContext(ApiContext);
}

export function ApiProvider(props: { children: JSX.Element }): JSX.Element {
  const [apiState, setApiState] = useState<ApiState>({
    activeRequests: 0,
    totalRequests: 0,
  });

  const api = useMemo(() => new Api(setApiState), []);

  return (
      <ApiContext.Provider value={api}>
        <ApiStateContext.Provider value={apiState}>
          {props.children}
        </ApiStateContext.Provider>
      </ApiContext.Provider>
  );
}
