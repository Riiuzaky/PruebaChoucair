package com.choucair.prueba.tasks;

import com.choucair.prueba.ui.LoginPage;
import com.choucair.prueba.utils.Constants;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
//import net.serenitybdd.screenplay.waits.Wait;




public class LoginTask implements Task {

    

    @Override
    public <T extends Actor> void performAs(T actor) {
        
        actor.attemptsTo(
            Enter.theValue(Constants.userName).into(LoginPage.INPUT_USER),
            Enter.theValue(Constants.password).into(LoginPage.INPUT_PASSWORD),
            Click.on(LoginPage.BUTTON_LOGIN)
            //Wait.until(() -> true).forNoMoreThan(10).seconds()
        );
    }

    public static LoginTask login() {

        return Tasks.instrumented(LoginTask.class);
    }

 

    

    
}
