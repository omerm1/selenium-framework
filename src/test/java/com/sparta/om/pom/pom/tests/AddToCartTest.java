package com.sparta.om.pom.pom.tests;

import com.sparta.om.pom.pom.dataproviders.MyDataProvider;
import com.sparta.om.pom.pom.objects.Product;
import com.sparta.om.pom.pom.base.BaseTest;
import com.sparta.om.pom.pom.pages.CartPage;
import com.sparta.om.pom.pom.pages.HomePage;
import com.sparta.om.pom.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartFromStorePage() throws IOException {
        Product product = new Product(1215);
        CartPage cartPage = new StorePage(getDriver()).load().
                getProductThumbnail().clickAddToCartBtn(product.getName()).
                clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
    }

    @Test(dataProvider = "getFeaturedProducts", dataProviderClass = MyDataProvider.class)
    public void addToCartFeaturedProducts(Product product){
        CartPage cartPage = new HomePage(getDriver()).load().
                getProductThumbnail().
                clickAddToCartBtn(product.getName()).
                clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
    }
}
