package com.github.amitagarwl.restclient;
/**
 * Created by amit.agarwal on 6/28/17.
 */

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class RestClient {

    public static Response getCall(final String endpoint) {
        return given().contentType(ContentType.JSON).log().everything().get(endpoint);

    }

    public static Response getCall(final String endpoint, final String username, final String password) {
        return given().contentType(ContentType.JSON).auth().preemptive().basic(username, password).get(endpoint);

    }


    public static Response getCall(final String endpoint, final String accessToken) {
        return given().contentType(ContentType.JSON).header(new Header("Authorization", "Bearer " + accessToken)).log().everything()
                .get(endpoint);

    }

    public static Response getCall(final String endpoint, final String pathParamKey, final String pathParamValue, final String accessToken) {
        return given().pathParam(pathParamKey, pathParamValue).contentType(ContentType.JSON)
                .header(new Header("Authorization", "Bearer " + accessToken)).get(endpoint);

    }

    public static Response postCall(final String endpoint, final String payload) {
        return given().contentType(ContentType.JSON).log().everything().body(payload).post(endpoint);

    }

    public static Response postCall(final String endpoint, final String payload, final String accessToken) {
        return given().contentType(ContentType.JSON).header(new Header("Authorization", "Bearer" + accessToken))
                .post(endpoint);

    }


    public static Response postCall(final String endpoint, final String payload, final String pathParamKey, final String pathParamValue, final String accessToken) {
        return given().pathParam(pathParamKey, pathParamValue).contentType(ContentType.JSON)
                .header(new Header("Authorization", "Bearer" + accessToken)).post(endpoint);

    }


}
