package com.choucair.prueba.stepdefinitions;



import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import com.choucair.prueba.questions.ValidationDataQuestion;
import com.choucair.prueba.tasks.FillFormEmployedTask;
import com.choucair.prueba.tasks.GoSectionRecruitmentTask;
import com.choucair.prueba.tasks.LoginTask;
import com.choucair.prueba.tasks.ProcessHiredTask;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;




public class RecruitmenStep {

    
    private Actor  actor;
    
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} navigate to web page")
    public void navigateToWebPage(String actor) {
        this.actor = theActorCalled(actor);
        this.actor.has(Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }

    @When("loggin whith valid credentials")
    public void logginWhithValidCredentials() {
       theActorInTheSpotlight().attemptsTo(
           LoginTask.login()
       );
    }

    @When("go to the section recruitment")
    public void goToTheSectionRecruitment() {
       theActorInTheSpotlight().attemptsTo(
           GoSectionRecruitmentTask.goSectionRecruitment()
       ); 
    }

    @When("fill the form whith the data a new employed")
    public void fillTheFormWhithTheDataANewEmployed() {
       theActorInTheSpotlight().attemptsTo(
           FillFormEmployedTask.fillFormEmployed(),
           ProcessHiredTask.processHired()
       );
    }

    @Then("can see the data of a new employed in the list  whit state Hired")
    public void canSeeTheDataOfANewEmployedInTheListWhitStateHired() {
        /* theActorInTheSpotlight().should(
          seeThat(
            ValidationDataQuestion.validationData()
          )  
        ); */
    }

}
