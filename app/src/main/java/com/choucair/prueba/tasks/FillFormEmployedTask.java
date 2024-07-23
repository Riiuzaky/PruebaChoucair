package com.choucair.prueba.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


import java.nio.file.Paths;



import com.choucair.prueba.ui.RecruitmentPage;
import com.choucair.prueba.utils.Constants;
import com.choucair.prueba.utils.ConvertJson;
import com.choucair.prueba.utils.Employed;
import com.choucair.prueba.utils.UtilsString;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;




public class FillFormEmployedTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        Employed employed = ConvertJson.handleJson(Constants.jsonUrl);
        String[] separatedDate = UtilsString.getSeparatedDate(employed.getDateOfAplication());
        try {
            actor.attemptsTo(
                Click.on(RecruitmentPage.BUTTON_ADD),
                WaitUntil.the(RecruitmentPage.INPUT_FIRST_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(employed.getFirstName()).into(RecruitmentPage.INPUT_FIRST_NAME),
                Enter.theValue(employed.getMiddleName()).into(RecruitmentPage.INPUT_MIDDLE_NAME),
                Enter.theValue(employed.getLastName()).into(RecruitmentPage.INPUT_LAST_NAME),
                Enter.theValue(employed.getEmail()).into(RecruitmentPage.INPUT_EMAIL),
                Enter.theValue(employed.getNumber()).into(RecruitmentPage.INPUT_NUMBER),
                Enter.theValue(employed.getKeywords()).into(RecruitmentPage.INPUT_KEYWORDS),
                Enter.theValue(employed.getNotes()).into(RecruitmentPage.TEXT_AREA_NOTES),
                //Enter.theValue(employed.getEmail()).into(RecruitmentPage.),
                Click.on(RecruitmentPage.LIST_VACANCY),
                //WaitUntil.the(RecruitmentPage.OPTIONS_VACANCY.of(employed.getVacancy()), isPresent()).forNoMoreThan(15).seconds(),
                Wait.until(() -> true).forNoMoreThan(10).seconds(),
                Click.on(RecruitmentPage.OPTIONS_VACANCY.of(employed.getVacancy())),
                Upload.theFile(Paths.get(employed.getResume())).to(RecruitmentPage.INPUT_FILE),

                
                Wait.until(() -> true).forNoMoreThan(10).seconds(), 
                
                //Enter.theValue("").into(RecruitmentPage.INPUT_DATE),
                Click.on(RecruitmentPage.INPUT_DATE),
                
                Click.on(RecruitmentPage.BUTTON_LIST_YEAR),
                Click.on(RecruitmentPage.BUTTON_YEAR.of(separatedDate[0])),
                Click.on(RecruitmentPage.BUTTON_LIST_MONTH),
                Click.on(RecruitmentPage.BUTTON_MONTH.of(separatedDate[2])),
                Click.on(RecruitmentPage.BUTTON_DAY.of(separatedDate[1])),

                Click.on(RecruitmentPage.CHECK_BOX_CONSENT),
                Click.on(RecruitmentPage.BUTTON_SAVE),

                WaitUntil.the(RecruitmentPage.BUTTON_CANDIDATES, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(RecruitmentPage.BUTTON_CANDIDATES)
                
                
               

                
                
            );
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        
        
    }


    public static FillFormEmployedTask fillFormEmployed() {
        return Tasks.instrumented(FillFormEmployedTask.class);
    }

}
