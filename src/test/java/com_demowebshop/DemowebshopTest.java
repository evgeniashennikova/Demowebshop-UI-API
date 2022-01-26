package com_demowebshop;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemowebshopTest extends TestBase {

    @Test
    @DisplayName("Добавление товара в Wishlist без использования cookie")
    void addToWishlistWithoutCookie() {

        apiSteps.addProductToWishlist();

    }

    @Test
    @DisplayName("Добавление товара в Wishlist c использованием cookie")
    void addToWishlistWithCookie() {

        apiSteps.addProductToWishlistWithCookie();

    }

    @Test
    @DisplayName("Проверка функции поиска")
    void searchStore() {

        apiSteps.checkSearchStore();

    }

    @Test
    @DisplayName("Удаление товара из Wishlist c использованием cookie (API+UI)")
    void updateWishlistWithCookie() {

        String cookie = apiSteps.addProductToWishlistWithCookie().cookie("Nop.customer");
        webSteps.setCookieForWishlist(cookie);
        webSteps.deleteProduct();

    }

    @Test
    @DisplayName("Проверка информации в аккаунте")
    void checkProfile() {

        String cookies = apiSteps.authWebsite().cookie("NOPCOMMERCE.AUTH");
        webSteps.setCookieForAuth(cookies);
        webSteps.checkUserInfo();

    }

}
