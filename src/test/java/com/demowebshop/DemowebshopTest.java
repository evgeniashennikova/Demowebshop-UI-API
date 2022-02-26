package com.demowebshop;


import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("Щенникова Е.")
public class DemowebshopTest extends TestBase {

    @Test
    @Story("Wishlist")
    @DisplayName("Добавление товара в Wishlist без использования cookie")
    void addToWishlistWithoutCookie() {
        apiSteps.addProductToWishlist();
    }

    @Test
    @Story("Wishlist")
    @DisplayName("Добавление товара в Wishlist c использованием cookie")
    void addToWishlistWithCookie() {
        apiSteps.addProductToWishlistWithCookie();
    }

    @Test
    @Story("Функция поиска")
    @DisplayName("Проверка функции поиска")
    void searchStore() {
        apiSteps.checkSearchStore();
    }

    @Test
    @Story("Wishlist")
    @DisplayName("Удаление товара из Wishlist c использованием cookie (API+UI)")
    void updateWishlistWithCookie() {
        String cookie = apiSteps.addProductToWishlistWithCookie().cookie("Nop.customer");
        webSteps.setCookieForWishlist(cookie);
        webSteps.deleteProduct();
    }

    @Test
    @Story("Аккаунт")
    @DisplayName("Проверка информации в аккаунте")
    void checkProfile() {
        String cookies = apiSteps.authWebsite().cookie("NOPCOMMERCE.AUTH");
        webSteps.setCookieForAuth(cookies);
        webSteps.checkUserInfo();
    }
}

