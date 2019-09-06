import ReactDOM from 'react-dom';
import React from 'react';

async function bootstrap() {
  const app = await import("./app");
  const api = await import("./lib/api");
  ReactDOM.render(
      <api.Api>
        <api.ApiStateContext.Consumer>
          {api => <app.App api={api}/>}
        </api.ApiStateContext.Consumer>
      </api.Api>,
      document.getElementById('main'));
}

bootstrap();
