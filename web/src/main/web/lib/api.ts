import {computed, observable} from "mobx";

class Api {

  @observable
  activeRequests = [];

  defaultUrl = document.location.href;

  @computed
  get loading() {
    return this.activeRequests.length > 0
  }

  async post(url: string, data: any) {
    url = this.defaultUrl + url;
    let responsePromise = fetch(new Request(url, {method: "post", body: JSON.stringify(data)}));
    this.activeRequests.push(responsePromise);
    let response = await responsePromise;
    let json = await response.json();
    this.activeRequests.splice(this.activeRequests.indexOf(responsePromise), 1);
    return json;
  }
}

export default new Api();