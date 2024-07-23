package com.choucair.prueba.questions;


import com.choucair.prueba.utils.Employed;



import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class ValidationDataQuestion implements Question<Boolean> {
    String validationName;
    Employed employed;

    @Override
    public Boolean answeredBy(Actor actor) {
        return true;
    }


    public static ValidationDataQuestion validationData() {
        return new ValidationDataQuestion();
    }

}
