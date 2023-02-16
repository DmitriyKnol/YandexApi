package org.example.main.pojo;

import io.restassured.RestAssured;

public class BaseApi {
    public void openUri() {
        RestAssured.baseURI = "https://cloud-api.yandex.net/v1";
    }
}
