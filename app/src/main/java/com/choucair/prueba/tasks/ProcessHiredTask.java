package com.choucair.prueba.tasks;


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
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProcessHiredTask implements Task {
    String validationName;
    Employed employed;

    @Override
    public <T extends Actor> void performAs(T actor) {
        employed = ConvertJson.handleJson(Constants.jsonUrl);
        validationName = employed.getFirstName()+" "+employed.getMiddleName()+" "+employed.getLastName();

        boolean buttonFound = isElementInthisPage(actor); // encontrar elemento -->
        String[] separatedDate = UtilsString.getSeparatedDate(employed.getDateOfAplication());
        if (buttonFound) {

            scrollToElement(actor, RecruitmentPage.BUTTON_ADD);

            

            // hacer scroll si no es clickable
            if (RecruitmentPage.BUTON_EXAMINAR.of(
                employed.getVacancy(),
                validationName,
                employed.getDateOfAplication(),
                Constants.defaultStatus)
                .resolveFor(actor).isClickable()) {

                actor.attemptsTo(
                        Click.on(RecruitmentPage.BUTON_EXAMINAR.of(
                                employed.getVacancy(),
                                validationName,
                                employed.getDateOfAplication(),
                                Constants.defaultStatus)));
            } else {
                actor.attemptsTo(
                        Scroll.to(RecruitmentPage.BUTON_EXAMINAR.of(
                                employed.getVacancy(),
                                validationName,
                                employed.getDateOfAplication(),
                                Constants.defaultStatus)),
                        Click.on(RecruitmentPage.BUTON_EXAMINAR.of(
                                employed.getVacancy(),
                                validationName,
                                employed.getDateOfAplication(),
                                Constants.defaultStatus)));
            }

            actor.attemptsTo(
                    Click.on(RecruitmentPage.BUTTON_SHORTLIST),
                    WaitUntil.the(RecruitmentPage.BUTTON_SAVE, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RecruitmentPage.BUTTON_SAVE),
                    
                    WaitUntil.the(RecruitmentPage.BUTTON_SCHEDULE_INTERVIEW, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RecruitmentPage.BUTTON_SCHEDULE_INTERVIEW),
                    
                    WaitUntil.the(RecruitmentPage.INPUT_INTERVIEW_TITLE, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue("QA test").into(RecruitmentPage.INPUT_INTERVIEW_TITLE),
                    Enter.theValue("a").into(RecruitmentPage.INPUT_INTERVIEWER),

                    WaitUntil.the(RecruitmentPage.INPUT_INTERVIEWER_OPTION, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RecruitmentPage.INPUT_INTERVIEWER_OPTION),

                    Enter.theValue("10:30 AM").into(RecruitmentPage.INPUT_HOUR),
                    Click.on(RecruitmentPage.INPUT_DATE),
                    Click.on(RecruitmentPage.BUTTON_LIST_YEAR),
                    Click.on(RecruitmentPage.BUTTON_YEAR.of(separatedDate[0])),
                    Click.on(RecruitmentPage.BUTTON_LIST_MONTH),
                    Click.on(RecruitmentPage.BUTTON_MONTH.of(separatedDate[2])),
                    Click.on(RecruitmentPage.BUTTON_DAY.of(separatedDate[1])),
                    Click.on(RecruitmentPage.BUTTON_SAVE),
                    WaitUntil.the(RecruitmentPage.BUTTON_INTERVIEW_PASEED, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RecruitmentPage.BUTTON_INTERVIEW_PASEED),
                    Click.on(RecruitmentPage.BUTTON_SAVE),

                    WaitUntil.the(RecruitmentPage.BUTTON_OFFERT_JOB, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RecruitmentPage.BUTTON_OFFERT_JOB),
                    Click.on(RecruitmentPage.BUTTON_SAVE),

                    WaitUntil.the(RecruitmentPage.BUTTON_HIRE, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RecruitmentPage.BUTTON_HIRE),
                    Click.on(RecruitmentPage.BUTTON_SAVE),

                    WaitUntil.the(RecruitmentPage.BUTTON_CANDIDATES, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RecruitmentPage.BUTTON_CANDIDATES)






            );


        }


    }

    public static ProcessHiredTask processHired() {
        return Tasks.instrumented(ProcessHiredTask.class);
    }

    public boolean isVisibleForTheActor(Target element, Actor actor, String... data) {
        return element.of(data).isVisibleFor(actor);
    }

    public void scrollToElement(Actor actor, Target element) {
        actor.attemptsTo(// scrroll to add
                WaitUntil.the(element, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(element)

        );
    }

    public boolean isElementInthisPage(Actor actor) {
        boolean buttonFound = false;
        boolean condition = isVisibleForTheActor(RecruitmentPage.BUTON_EXAMINAR, actor,
                employed.getVacancy(),
                validationName,
                employed.getDateOfAplication(),
                Constants.defaultStatus);
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

}
