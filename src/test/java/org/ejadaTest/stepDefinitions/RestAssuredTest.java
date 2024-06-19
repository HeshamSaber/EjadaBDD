package org.ejadaTest.stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RestAssuredTest {
    String token = "9733609f5c41297eb61f20414fe2c429e1501dd0ccc97566fdd775cde38e328d";
    String orderID = "lJ2Nfp1XDb66Mik7nu3KN";

    @Test
    public void testGetStatus() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        RestAssured.given()
                .when()
                .get("/status")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testGetBooks() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        RestAssured.given()
                .queryParam("type", "fiction")
                .queryParam("limit", 10)
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testAutherization() {
        String body = "{\"clientName\": \"Ejada\",\"clientEmail\": \"Ejada5@Ejada.com\"}";
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/api-clients")
                .then()
                .statusCode(201)
                .log().all().extract().response();
        token = response.jsonPath().getString("accessToken");
    }

    @Test
    public void singleBook() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        RestAssured.given()
                .when()
                .get("/books/1")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void orderBook() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        String bodyText = "{\"bookId\": 1,\"customerName\": \"John\"}";

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(bodyText)
                .when()
                .post("/orders")
                .then()
                .statusCode(201)
                .log().all().extract().response();
        orderID = response.jsonPath().getString("orderId");
        System.out.println(orderID);
    }
    @Test
    public void getOrdersList() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .when()
                .get("/orders")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getSingleOrder() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .when()
                .get("/orders/" + orderID)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void patchOrder() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        String bodyText = "{\"customerName\": \"Jack\"}";

        RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(bodyText)
                .when()
                .patch("/orders/" + orderID)
                .then()
                .statusCode(204)
                .log().all();

    }

    @Test
    public void deleteOrder() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .when()
                .delete("/orders/" + orderID)
                .then()
                .statusCode(204)
                .log().all();
    }


}