import ReactDOM from 'react-dom';
import React from 'react';

async function bootstrap() {
  const App = (await import("./app")).default;
  const Api = (await import("./lib/api")).default;
  ReactDOM.render(
      <Api>
        <App/>
      </Api>,
      document.getElementById('main'));
}

bootstrap();
