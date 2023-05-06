package com.devsu.api.demoblaze.util.resource;

import com.devsu.api.demoblaze.util.constants.Endpoints;

public enum WebServiceEndPoints {
    URI_SIGNUP(Endpoints.URL_SIGNUP),
    URI_SINGIN(Endpoints.URL_SINGIN);

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
