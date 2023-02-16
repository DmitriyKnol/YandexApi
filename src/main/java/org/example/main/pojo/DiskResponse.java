package org.example.main.pojo;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.equalTo;

public class DiskResponse {
    @Step ("Проверка статус кода")
    public void statusCreated(Response status) {
        status
                .then()
                .statusCode(SC_CREATED);
    }
    @Step ("Проверка тела ответа")
    public void bodyResponseCreatedFile(Response status) {
        BodyResponseDisk bodyResponseDisk = status
                .then()
                .extract().body().as(BodyResponseDisk.class);

        status
                .then()
                .assertThat()
                .body("method", equalTo("GET"));
    }
}
