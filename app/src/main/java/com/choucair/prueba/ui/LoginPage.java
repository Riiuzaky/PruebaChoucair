package com.choucair.prueba.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target INPUT_USER = Target.the("input user").located(By.name("username"));
    public static final Target INPUT_PASSWORD = Target.the("input password").located(By.name("password"));
    public static final Target BUTTON_LOGIN = Target.the("button login").located(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"));
    
}
