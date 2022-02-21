package com_demowebshop;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com_demowebshop.filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;

public class Spec {

    public static RequestSpecification request = with()
            .filter(customLogFilter().withCustomTemplates())
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .log().all();

    public static ResponseSpecification response = with()
            .expect().statusCode(200)
            .log().body();
}

