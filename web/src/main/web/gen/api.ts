/* tslint:disable */
/* eslint-disable */

export interface Pong {
    pong?: string;
}

export interface HttpClient {

    request<R>(requestConfig: { method: string; url: string; queryParams?: any; data?: any; copyFn?: (data: R) => R; }): RestResponse<R>;
}

export class RestApplicationClient {

    constructor(protected httpClient: HttpClient) {
    }

    /**
     * HTTP POST /api/ping
     * Java method: com.nthalk.webstack.web.api.PingApi.ping
     */
    ping(): RestResponse<Pong> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/ping` });
    }
}

export type RestResponse<R> = Promise<R>;

function uriEncoding(template: TemplateStringsArray, ...substitutions: any[]): string {
    let result = "";
    for (let i = 0; i < substitutions.length; i++) {
        result += template[i];
        result += encodeURIComponent(substitutions[i]);
    }
    result += template[template.length - 1];
    return result;
}
