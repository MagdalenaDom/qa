package com.jsystems.qaapi.service;

import com.jsystems.qaapi.model.error.ErrorResponse;
import com.jsystems.qaapi.model.user.MyUser;
import com.jsystems.qaapi.model.device.User;
import com.jsystems.qaapi.specification.Specification;
import io.restassured.RestAssured;

import java.util.List;

public class ApiService {
    private static final String USERS_LIST = "/5a6a58222e0000d0377a7789";
    private static final String USER = "/5a6b69ec3100009d211b8aeb";
    private static final String POST_URL = "/5a690a1b2e000051007a73cb";
    public static final String ERROR_URL = "/5a690b452e000054007a73cd";


    public static List<User> getUsers(){
        return RestAssured
                .given()
                .spec(Specification.requestSpecBuilder())
//                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .get(USERS_LIST)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", User.class);
    }

    public static MyUser getUser(){

            return RestAssured
                    .given()
                    .spec(Specification.requestSpecBuilder())
//                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                    .queryParam("name", "Piotr")
                    .queryParam("surname", "Kowalski")
                    .get(USER)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract()
                    .body()
                    .jsonPath()
                    .getObject("", MyUser.class);
        }

        public static String[] postMyUser(MyUser user){
        return RestAssured
                .given()
                .spec(Specification.requestSpecBuilder())
                .body(user)
                .post(POST_URL)
                .andReturn()
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .as(String[].class);
        }
public static ErrorResponse getErrorResponse(){
        return RestAssured
                .given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .get(ERROR_URL)
                .then()
                .assertThat()
                .statusCode(400)
                .extract()
                .as(ErrorResponse.class);
}

    }

