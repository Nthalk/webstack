/* tslint:disable */
/* eslint-disable */

export interface ApiError {
    code: ErrorCode;
    message: string;
    stack: string;
}

export interface ApiResult<T> {
    result?: T;
    error?: RootApiError;
}

export interface RootApiError {
    code: ErrorCode;
    message: string;
    stack?: string;
    fieldErrors?: { [index: string]: ApiError };
    globalErrors?: ApiError[];
}

export interface Pong {
    pong: string;
}

export interface HttpClient {

    request<R>(requestConfig: { method: string; url: string; queryParams?: any; data?: any; copyFn?: (data: R) => R; }): RestResponse<R>;
}

export class TestApiClient {

    constructor(protected httpClient: HttpClient) {
    }

    /**
     * HTTP POST /api/test
     * Java method: com.nthalk.webstack.web.api.TestApi.ping
     */
    ping(): RestResponse<ApiResult<Pong>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/test` });
    }
}

export type RestResponse<R> = Promise<R>;

export type ErrorCode = "UNKNOWN";

function uriEncoding(template: TemplateStringsArray, ...substitutions: any[]): string {
    let result = "";
    for (let i = 0; i < substitutions.length; i++) {
        result += template[i];
        result += encodeURIComponent(substitutions[i]);
    }
    result += template[template.length - 1];
    return result;
}
