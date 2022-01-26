package com_demowebshop.steps;

import config.UserCredential;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;

import static com_demowebshop.filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiSteps {

    public static UserCredential credential = ConfigFactory.create(UserCredential.class);

    @Step("Добавление товара в Wishlist без использования cookie")
    public ValidatableResponse addProductToWishlist() {

        String data = "addtocart_14.EnteredQuantity=2"; // добавляем в Wishlist товар в кол-ве 2 штук

        return given()
                .filter(customLogFilter().withCustomTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(data)
                .when()
                .log().uri()
                .log().body()
                .post("/addproducttocart/details/14/2")
                .then()
                .log().body()
                .statusCode(200)
                .body("success", is(true),
                        "message", is("The product has been added to your \u003ca href=\"/wishlist\"\u003ewishlist\u003c/a\u003e"),
                        "updatetopwishlistsectionhtml", is("(2)"));
    }

    @Step("Добавление товара в Wishlist c использованием cookie")
    public Response addProductToWishlistWithCookie() {

        String data = "addtocart_14.EnteredQuantity=1";

        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(credential.cookie())
                .body(data)
                .when()
                .post("/addproducttocart/details/14/2")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Step("Проверка функции поиска")
    public ValidatableResponse checkSearchStore() {

        String valueSearch = "book";

        return given()
                .when()
                .get("/search?q=" + valueSearch)
                .then()
                .statusCode(200);
    }

    @Step("Авторизоваться на сайте demowebshop.tricentis.com")
    public Response authWebsite() {

        return (Response) given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("Email", credential.login())
                .formParam("Password", credential.password())
                .when()
                .post("login")
                .then()
                .statusCode(302)
                .extract()
                .response();

    }

}
