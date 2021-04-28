import React, {useEffect, useState} from 'react';
import {useApi} from './providers/ApiProvider';
import {ApiResult, Pong} from "./gen/api";

export default function App(): JSX.Element {
  const api = useApi();
  const [rsp, setRsp] = useState<ApiResult<Pong>>();
  useEffect(() => {
    (async () => {
      const pong = await api.test.ping();
      console.log(pong);
      setRsp(pong);
    })();
  }, [api.test]);

  return (
      <div>
        <a href="/auth/google">Login</a>
        {JSON.stringify(rsp)}
      </div>
  );
}
