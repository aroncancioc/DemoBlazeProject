package co.com.certification.demoblaze.stepdefinitions;

import co.com.certification.demoblaze.questions.PurchaseVerification;
import co.com.certification.demoblaze.questions.UserVerification;
import co.com.certification.demoblaze.tasks.LogIn;
import co.com.certification.demoblaze.tasks.LogInCart;
import co.com.certification.demoblaze.tasks.MakePurchase;
import co.com.certification.demoblaze.tasks.Register;
import co.com.certification.demoblaze.userinterfaces.Cart;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegisterStepDefinitions {
    @Managed(driver = "chrome")
    WebDriver hisdriver;

    @Before
    public void setThestage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Alejandro");
    }

    @Given("I am a user without credentials")
    public void iAmAUserWithoutCredentials() {
        theActorInTheSpotlight().wasAbleTo(Open.url("https://www.demoblaze.com/"));
    }

    @When("Enter the information needed to create a user")
    public void enterTheInformationNeededToCreateAUser() {
        theActorInTheSpotlight().attemptsTo(Register.register());
        theActorInTheSpotlight().attemptsTo(LogIn.logIn());
    }

    @Then("Registration successful")
    public void registrationSuccessful() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(UserVerification.isSuccessful())
        );
    }

    @Given("I am a DemoBlaze's user")
    public void iAmADemoBlazeSUser() {
        theActorInTheSpotlight().wasAbleTo(Open.url("https://www.demoblaze.com/"));
    }

    @When("I add two products to the cart")
    public void iAddTwoProductsToTheCart() {
        theActorInTheSpotlight().attemptsTo(LogInCart.logInCart());
    }

    @And("the order is placed")
    public void theOrderIsPlaced() {
        theActorInTheSpotlight().attemptsTo(MakePurchase.makePurchase());
    }

    @Then("purchase successful confirmed")
    public void purchaseSuccessfulConfirmed() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(PurchaseVerification.isSuccessful()));
        theActorInTheSpotlight().wasAbleTo(Click.on(Cart.ButtonOK));
    }
}
