package com.example.Library.restController;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    void createBook() {
        given()
                .contentType("application/json")
                .body("{\"title\":\"Test Book\",\"author\":\"Test Author\"}")
                .when()
                .post("/book/create")
                .then()
                .statusCode(302);
    }

    @Test
    void deleteBook() {
        given()
                .when()
                .delete("/book/delete/{id}", 1)
                .then()
                .statusCode(302);
    }
}