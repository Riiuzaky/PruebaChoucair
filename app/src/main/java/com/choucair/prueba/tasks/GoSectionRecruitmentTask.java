package com.choucair.prueba.tasks;

import com.choucair.prueba.ui.HomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoSectionRecruitmentTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            
            WaitUntil.the(HomePage.ANCHOR_RECRUIMET, isVisible()).forNoMoreThan(10).seconds(),
            MoveMouse.to(HomePage.ANCHOR_RECRUIMET),
            Click.on(HomePage.ANCHOR_RECRUIMET),
            Wait.until(() -> true).forNoMoreThan(10).seconds()
        );
    }

    public static GoSectionRecruitmentTask goSectionRecruitment() {
        return Tasks.instrumented(GoSectionRecruitmentTask.class);
    }
    
}
