package com.demowebshop;

import com.demowebshop.filters.CustomLogFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Spec {

    public static RequestSpecification request = with()
            .filter(CustomLogFilter.withCustomTemplates())
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .log().all();

    public static ResponseSpecification response = with()
            .expect().statusCode(200)
            .log().body();
}

