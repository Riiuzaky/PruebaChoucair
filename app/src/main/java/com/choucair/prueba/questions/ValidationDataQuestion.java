package com.choucair.prueba.questions;


import com.choucair.prueba.ui.RecruitmentPage;
import com.choucair.prueba.utils.Constants;
import com.choucair.prueba.utils.Employed;



import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import com.choucair.prueba.utils.ConvertJson;



public class ValidationDataQuestion implements Question<Boolean> {
    String validationName;
    Employed employed;


    @Override
    public Boolean answeredBy(Actor actor) {
        
        try {
            employed = ConvertJson.handleJson(Constants.jsonUrl);
            validationName = employed.getFirstName()+" "+employed.getMiddleName()+" "+employed.getLastName();
            boolean result = isElementInthisPage(actor);
            return result;
        } catch (Exception e) {
            // Log the exception or provide additional debugging information
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        
    }


    public static ValidationDataQuestion isValidationData() {
        return new ValidationDataQuestion();
    }


    public boolean isElementInthisPage(Actor actor) {
        boolean buttonFound = false;
        boolean condition = isVisibleForTheActor(RecruitmentPage.ROW_CANDIDATE, actor,
                employed.getVacancy(),
                validationName,
                employed.getDateOfAplication(),
                employed.getStatus());
        while (!buttonFound) {
            if (condition) {
                buttonFound = true;
            } else {
                actor.attemptsTo(
                        Click.on(RecruitmentPage.BTN_NEXT_PAGE));
            }
        }
        return buttonFound;
    }



    public boolean isVisibleForTheActor(Target element, Actor actor, String... data) {
        return element.of(data).isVisibleFor(actor);
    }

}
