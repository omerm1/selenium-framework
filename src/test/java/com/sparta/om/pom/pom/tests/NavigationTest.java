package com.sparta.om.pom.pom.tests;

import com.sparta.om.pom.pom.base.BaseTest;
import com.sparta.om.pom.pom.pages.HomePage;
import com.sparta.om.pom.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void NavigateFromHomeToStoreUsingMainMenu(){
        StorePage storePage = new HomePage(getDriver()).
                load().getMyHeader().
                navigateToStoreUsingMenu();
        Assert.assertEquals(storePage.getTitle(), "Store");
    }
}
