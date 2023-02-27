package com.sparta.om.pom.pom.tests;

import com.sparta.om.pom.pom.objects.Product;
import com.sparta.om.pom.pom.objects.User;
import com.sparta.om.pom.pom.utils.FakerUtils;
import com.sparta.om.pom.pom.api.actions.CartApi;
import com.sparta.om.pom.pom.api.actions.SignUpApi;
import com.sparta.om.pom.pom.base.BaseTest;
import com.sparta.om.pom.pom.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginDuringCheckout() throws Exception {
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demopwd").
                setEmail(username + "@askomdch.com");

        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
        CartApi cartApi = new CartApi();
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();
        checkoutPage.
                clickHereToLoginLink().
                login(user);
        Assert.assertTrue(checkoutPage.getProductName().contains(product.getName()));
    }
}
