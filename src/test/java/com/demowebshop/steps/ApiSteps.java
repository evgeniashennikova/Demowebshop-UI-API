package com.demowebshop.steps;

import com.demowebshop.config.UserCredential;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;

import static com.demowebshop.Spec.request;
import static com.demowebshop.Spec.response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiSteps {

    public static UserCredential credential = ConfigFactory.create(UserCredential.class);

    @Step("Добавление товара в Wishlist без использования cookie")
    public ValidatableResponse addProductToWishlist() {
        String data = "addtocart_14.EnteredQuantity=2"; // добавляем в Wishlist товар в кол-ве 2 штук
        return given()
                .spec(request)
                .body(data)
                .when()
                .post("/addproducttocart/details/14/2")
                .then()
                .spec(response)
                .body("success", is(true),
                        "message", is("The product has been added to your \u003ca href=\"/wishlist\"\u003ewishlist\u003c/a\u003e"),
                        "updatetopwishlistsectionhtml", is("(2)"));
    }

    @Step("Добавление товара в Wishlist c использованием cookie")
    public Response addProductToWishlistWithCookie() {
        String data = "addtocart_14.EnteredQuantity=1";
        return given()
                .spec(request)
                .cookie(credential.cookie())
                .body(data)
                .when()
                .post("/addproducttocart/details/14/2")
                .then()
                .spec(response)
                .extract()
                .response();
    }

    @Step("Проверка функции поиска")
    public ValidatableResponse checkSearchStore() {
        String valueSearch = "book";
        return given()
                .spec(request)
                .when()
                .get("/search?q=" + valueSearch)
                .then()
                .spec(response);
    }

    @Step("Авторизоваться на сайте demowebshop.tricentis.com")
    public Response authWebsite() {
        return given()
                .spec(request)
                .formParam("Email", credential.login())
                .formParam("Password", credential.password())
                .when()
                .post("login")
                .then()
                .statusCode(302)
                .log().body()
                .extract()
                .response();
    }
}

