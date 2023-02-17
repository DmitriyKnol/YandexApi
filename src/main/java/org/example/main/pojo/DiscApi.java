package org.example.main.pojo;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DiscApi {
    private static final String handlerFolder = "/disk/resources";
    Faker faker = new Faker();
    private String nameFolder = faker.funnyName().name();
    private String token = "y0_AgAAAABonfR1AAkkkwAAAADcUFRn1JdGFatqSteYdye28RzLUDaWMN4";
    @Step("Создание папки")
    public Response createFolder() {
         Response response =
                given()
                        .header("Authorization", token)
                        .param("path", nameFolder)
                        .when()
                        .put(handlerFolder);
        return response;
    }
    @Step ("Удаление папки")
    public void deleteFolder() {
                given()
                        .header("Authorization", token)
                        .param("path", nameFolder)
                        .when()
                        .delete(handlerFolder);
    }
}
